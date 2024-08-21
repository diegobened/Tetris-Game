package tetris;

/**
 * Import des packages utiles à la classe
 */
import java.awt.*;
import java.util.Random;

public class Shape {
    
    /**
     * Générateur alétoire permettant de générer les pièces du Tétris
     */
    static Random r = new Random();
    
    /**
     * Constructeur, générateur de la shape qui va tomber et de la future shape.
     * @param aThis 
     */
    Shape(Board aThis) {
        b = aThis;
        clr = setShape(coords);
        clrSuivant = setShape(coordsSuivant);
    }
    
    /*
    Les différentes fonctions pour se déplacer sur la grille, la première consiste
    au déplacement selon les x, pour ce faire on regarde si la case que lon souhaite
    atteindre est remplie, et ce, pour chaque composante du Tétrimino.
    
    Pour les déplacements en y la règle est la même sauf qu'il faut savoir en plus
    quand s'arrêter, c'est le rôle de la fonction setShape() et dans le cas où
    on ne peut plus descendre et que l'on s'est installé on procède à l'algorithme
    qui enlève les lignes.
    */
    
    /**
     * Permet de se déplacer horizontalement sur la grille de jeu. Le sens positif étant vers la droite.
     * @param dx Nombre de cases à se déplacer
     */
    void moveX(int dx) {
        for (Point p : coords) {
            if (b.getCase(p.x + centre.x + dx, p.y + centre.y).isFilled()) {
                return;
            }
        }
        centre.x += dx;

    }
    
    
    // Renvoie true si la forme s'est figée dans le board.
    /**
     * Permet de déplacer les pièces selon l'axe vertical et de figer les pièces qui atteignent le bas ou qui recontrent une autre pièce lors de la descente.
     * @param dy Nombre de cases de déplacement
     * @return Retourne si la pièce à pu se mouvoir selon l'axe vetical
     */
    synchronized boolean moveY(int dy) {
        for (Point p : coords) { // On regarde si on peut descendre pour chaque point qui compose la pièce
            if (b.getCase(p.x + centre.x, p.y + centre.y + dy).isFilled()) {
                for (Point p2 : coords) {
                    // On se fige dans le plateau
                    b.getCase(p2.x + centre.x, p2.y + centre.y).fill(clr);
                }
                b.checkGameOver(); // On regarde si la partie se termine
                b.removeFullLines(); // On vire les lignes complètes
                nextShape(); // On passe à la shape suivante
                return true;
            }
        }
        centre.y += dy;
        return false;
    }

    //Attributs de mon Tétrimino
    /**
     * Coordonnées des composantes du Tétrimino
     */
    private Point[] coords = new Point[4];
    /**
     * Coordonnées des composantes du prochain Tétrimino
     */
    private Point[] coordsSuivant = new Point[4];
    /**
     * Point central du Tétrimino
     */
    Point centre = new Point(4, 1);
    /**
     * Point central du prochain Tétrimino
     */
    Point centreSuivant = new Point(2, 2);
    /**
     * Le Tétrimino se souvient du board sur laquel il descend
     */
    Board b;
    /**
     * Couleur du Tétrimo actuel
     */
    Color clr = Color.BLACK;
    /**
     * Couleur du prochain Tétrimino
     */
    Color clrSuivant = Color.MAGENTA;
    /**
     * La shape se souvient de la box de preview pour pouvoir s'y afficher.
     */
    Preview prev;
    
    /**
     * Permet de dessiner notre Tétrimono
     * @param g Graphique
     * @param ech Dimensions
     */
    public void dessineToi(Graphics g, Dimension ech) {
        for (Point p : coords) {
            g.setColor(clr);
            g.fillRect((p.x + centre.x) * ech.width, (p.y + centre.y) * ech.height, ech.width, ech.height);
            g.setColor(Color.BLACK);
            g.drawRect((p.x + centre.x) * ech.width, (p.y + centre.y) * ech.height, ech.width, ech.height);
        }
    }
    
    /*
    Cette fonction à la particularité de générer un nombre aléatoire, et en fonction
    de ce nombre, une pièce est choisie. Ainsi dans les coordonnées du Tétrimino
    on indique la position relative des composantes par rapport au centre, par exemple,
    pour le Tétrimino en O (le carré) ses composantes sont sur les côtés droits 
    et dessous en prenant le carré haut gauche comme centre.
    */
    /**
     * Génère une pièce aléatoire grâce au générateur placé en attribut et lui attribut les coordonées de ses composantes ainsi que sa couleur, propre à chaque forme de Tétrimino
     */
    public Color setShape(Point[] coords) {
        switch (r.nextInt(7)+1) {
            case 1:
                coords[0] = new Point(-1, 0);
                coords[1] = new Point(0, 0);
                coords[2] = new Point(1, 0);
                coords[3] = new Point(2, 0);
                return Color.CYAN;
            case 2:
                coords[0] = new Point(0, 0);
                coords[1] = new Point(0, 1);
                coords[2] = new Point(1, 0);
                coords[3] = new Point(1, 1);
                return Color.YELLOW;
            case 3:
                coords[0] = new Point(-1, 0);
                coords[1] = new Point(0, 0);
                coords[2] = new Point(1, 0);
                coords[3] = new Point(0, -1);
                return Color.MAGENTA;
            case 4:
                coords[0] = new Point(-1, 0);
                coords[1] = new Point(0, 0);
                coords[2] = new Point(1, 0);
                coords[3] = new Point(-1, -1);
                return Color.ORANGE;
            case 5:
                coords[0] = new Point(-1, 0);
                coords[1] = new Point(0, 0);
                coords[2] = new Point(1, 0);
                coords[3] = new Point(1, -1);
                return Color.BLUE;
            case 6:
                coords[0] = new Point(-1, 0);
                coords[1] = new Point(0, 0);
                coords[2] = new Point(0, 1);
                coords[3] = new Point(1, 1);
                return Color.RED;
            case 7:
                coords[0] = new Point(1, 0);
                coords[1] = new Point(0, 0);
                coords[2] = new Point(-1, 1);
                coords[3] = new Point(0, 1);
                return Color.GREEN;
        }
        return Color.BLACK; // Normalement cette ligne n'est pas atteinte
    }
    
    /**
     * Permet de passer à la shape suivante et créer la nouvelle prochaine shape.
     */
    public void nextShape() {
        for (int i=0; i<coords.length;i++) { // On passe les coordonées à la shape principale.
            coords[i] = coordsSuivant[i];
        }
        centre = new Point(4, 1); // On replace la pièce
        clr = clrSuivant; // On passe la couleur
        clrSuivant = setShape(coordsSuivant); // On créé la pièce suivante
        prev.repaint(); // On redessine la box de preview
    }
    
    /*
    La rotation, se fait dans le sens horaire, seule possibilité dans ce jeu,
    et l'on regarde aussi, une fois le Tétrimino retourné s'il rentre dans un mur.
    Si tel est le cas, alors on le repousse de ce mur jusqu'à ce qu'il n'y soit plus.
    */
    /**
     * Rotation, dans le sens horaire, de la pièce en cours de jeu. Si cette dernière rencontre un mur elle est alors repoussée.
     */
    public void rotate() {
        for (Point p : coords) {
            int tmp=p.x;
            p.x=-p.y;
            p.y=tmp;
        }
        boolean test = true;
        while (test) {
            test = false;
            for (Point p : coords) {
                if (centre.x+p.x>=b.gr.length) {
                    centre.x-=1;
                    test = true;
                }
                else {
                    if (0>centre.x+p.x) {
                        centre.x+=1;
                        test = true;
                    }
                }
            }
        }
    }
    
    /*
    Le Hard Drop est une technique importante du jeu, elle permet de faire directement
    descendre un Tétrimino et de gagner de nombreux points. Cette fonction retourne
    le nombre de cases descendues que l'on multipliera plus tard par 2 pour l'ajouter
    au score.
    */
    
    /**
     * Permet de hard drop une pièce (descente rapide).
     * @return Retourne la distance parcourue pendant la chute rapide de la pièce.
     */
    public int hardDrop() {
        int distance = 0;
        while (!moveY(1)) {
            distance++;
        }
        b.boardARafraichir=true;
        return distance;
    }
    
    /**
     * Affichage de la Shape dans la box de preview.
     * @param g Graphique
     * @param ech Echelle de la classe Dimension
     */
    void showNextShapeInPreview(Graphics g, Dimension ech) {
        for (Point p : coordsSuivant) {
            g.setColor(clrSuivant);
            g.fillRect((p.x + centreSuivant.x) * ech.width, (p.y + centreSuivant.y) * ech.height, ech.width, ech.height);
            g.setColor(Color.BLACK);
            g.drawRect((p.x + centreSuivant.x) * ech.width, (p.y + centreSuivant.y) * ech.height, ech.width, ech.height);
        }
    }
    
    /**
     * Attache la box de preview à note pièce.
     * @param aThis Preview
     */
    void setInPreview(Preview aThis) {
        prev = aThis;
    }
}
