package tetris;

/**
 * Import de toutes les bibliothèques nécessaires au programme.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Board extends Canvas implements KeyListener, ActionListener {

    /**
     * On créé un tableau de 10 cases de largeur par 22 cases de longueur.
     */
    Case[][] gr = new Case[10][22];
    /**
     * Attribut permettant de caractériser l'extérieur.
     */
    Case ext = new Case();
    /**
     * Attribut donnant la dimension des cases.
     */
    Dimension ech = new Dimension();
    /**
     * On initialise ici notre shape qui va tomber le long du jeu.
     */
    Shape s = new Shape(this);
    /**
     * Attribut (classe Timer) permettant de selectionner la vitesse du jeu et
     * la vitesse d'exécution des commandes.
     */
    Timer t = new Timer(800, this);
    /**
     * Initialisation des images nécessaires à la mise en double buffer du board
     * pour permettre un meilleur affichage du jeu et évciter tout effet
     * d'artéfact.
     */
    Image img;
    /**
     * Initialisation de la deuxième image.
     */
    Image img2;
    /**
     * Attribut permettant de savoir si le board actuel est à rafraîchir (true)
     * ou non (false).
     */
    boolean boardARafraichir;
    /**
     * Détermine le niveau du joueur.
     */
    int level = 0;
    /**
     * Détermine le nombre de lignes effacées dans la partie en cours.
     */
    int lines = 0;
    /**
     * Déterminne le score de la partie en cours.
     */
    int score = 0;
    /**
     * Détermine si le jeu est actuellement en pause (true) ou non (false).
     */
    boolean gamePaused = false;
    /**
     * attributs permettant l'affichage sur la fenêtre de jeu du score, du level
     * et des lines effectuées
     */
    JLabel champScore;
    JLabel champLevel;
    JLabel champLines;

    /**
     * Construit le tableau de jeu.
     */
    public Board() {
        ext.fill(Color.RED);
        for (int x = 0; x < gr.length; x++) {
            for (int y = 0; y < gr[0].length; y++) {
                gr[x][y] = new Case();
            }
        }
        addKeyListener(this);
        t.start();
    }

    /**
     * Mise à jour de l'interface du board.
     */
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Dessine une première fois les images du buffer.
     *
     * @param g
     */
    public void paint(Graphics g) {
        ech.width = getWidth() / gr.length;
        ech.height = getHeight() / gr[0].length;
        requestFocus();
        if (boardARafraichir || img == null) {
            paintBoard();
        }
        Graphics g2 = img2.getGraphics();
        g2.drawImage(img, 0, 0, this);
        s.dessineToi(g2, ech);
        g.drawImage(img2, 0, 0, this);
    }

    /**
     * Dessine une première fois le board.
     */
    private void paintBoard() {
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        img2 = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = img.getGraphics();
        for (int x = 0; x < gr.length; x++) {
            for (int y = 0; y < gr[0].length; y++) {
                gr[x][y].dessineToi(x, y, g, ech);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Observation des touches enfoncées, les flèches (37 et 39) bougent la
     * pièce, la flèche du haut (38) la fait tourner dans le sens horaire, la
     * flèche du bas (40) procède au soft drop et la barre espace procède au
     * hard drop. Enfin, la touche p permet de mettre le jeu en pause.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37: // Flèche gauche
                s.moveX(-1);
                break;
            case 38: // Flèche haut
                s.rotate();
                break;
            case 39: // Flèche droite
                s.moveX(1);
                break;
            case 40: // Flèche bas
                boardARafraichir = s.moveY(1);
                score++;
                setScore();
                break;
            case 32: // Barre d'espace
                score += 2 * s.hardDrop();
                setScore();
                break;
            case 80: // Touche P
                if (gamePaused) {
                    unpause();
                } else {
                    pause();
                }
                break;
            case 82: // Touche R
                restart();
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * S'actualise à chaque tour du Timer terminé, soit un mouvement de pièce à
     * début de délai indiqué au Timer (0,8 s) au début du jeu.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        boardARafraichir = s.moveY(1);
        repaint();
    }

    /**
     * Fonction qui retourne la case du tableau associée aux coordonnées x et y
     * d'entrée. Renvoie ext en cas d'un case qui dépasserai les limites du
     * tableau.
     *
     * @param x coordonée d'abscisse
     * @param y coordonée d'ordonnée
     * @return Case associée aux coordonées (type Case)
     */
    public Case getCase(int x, int y) {
        if (x < 0 || x >= gr.length) {
            return ext;
        }
        if (y < 0 || y >= gr[0].length) {
            return ext;
        }
        return gr[x][y];
    }

    /**
     * Début du bloc pour retirer les lignes , tout d'abord pour chaque ligne on
     * regarde si celle-ci est complète, si elle ne l'est pas on passe à la
     * ligne du haut, sinon, On demande à retirer cette ligne et on ajoute 1 au
     * compteur du nombre de lignes effacées et 1 au nombre de lignes totales
     * effacées. Ensuite on calcul le score obtenu et on regarde si le niveau du
     * jeu à augmenté pour enfin repeindre le board.
     */
    void removeFullLines() {
        int m = gr[0].length;
        int erasedLines = lines;
        for (int y = m - 1; y > 1;) {
            if (checkLineFull(y)) { // On regarde si la ligne est complète (complètement "filled")
                removeLine(y); // Si oui, on la retire
                packLines(y); // On tasse les lignes
                lines++; // Le nombre de lignes augmente
                erasedLines++; // Le nombre de lignes effacées dans l'exécution augmente
            } else {
                y--;
            }
        }
        switch (erasedLines) { // Switch qui donne un nombre de points différent en fonction du nombre de lignes effacées lors de l'exécution actuelle
            case 0:
                break;
            case 1:
                score = 100 * (level + 1) + score;
                break;
            case 2:
                score = 300 * (level + 1) + score;
                break;
            case 3:
                score = 500 * (level + 1) + score;
                break;
            case 4:
                score = 800 * (level + 1) + score;
                break;
        }
        checkLevel();
        setScore();
        setLines();
        setLevel();
        repaint();
    }

    /**
     * Permet de regarder si la ligne y est complète au sens d'être "filled"
     *
     * @param y ordonnée
     * @return True si la ligne est complète, false sinon
     */
    boolean checkLineFull(int y) {
        int n = gr.length;
        int count = 0;
        for (int x = 0; x < n; x++) {
            if (gr[x][y].isFilled()) {
                count += 1;
            }
        }
        return count == n;
    }

    /**
     * Permet de retirer une ligne
     *
     * @param y ordonnée de la ligne
     */
    private void removeLine(int y) {
        int n = gr.length;
        for (int x = 0; x < n; x++) {
            gr[x][y].setUnfilled();
            gr[x][y].fill(Color.WHITE);
        }
    }

    /**
     * Permet de tasser les lignes
     *
     * @param h ordonnée de départ du tassage des lignes
     */
    private void packLines(int h) {
        int n = gr.length;
        for (int y = h; y > 0; y--) {
            for (int x = 0; x < n; x++) {
                gr[x][y] = gr[x][y - 1];
            }
        }
        for (int x = 0; x < n; x++) {
            gr[x][0] = new Case();
        }
    }

    /**
     * Met le jeu en pause
     */
    public void pause() {
        t.stop();
        gamePaused = true;
    }

    /**
     * Retire le jeu de la pause
     */
    public void unpause() {
        t.start();
        gamePaused = false;
    }

    /**
     * Permet de vérifier si le niveau actuel est le bon, le niveau doit être
     * lines/10.
     */
    private void checkLevel() {
        int supposedLevel = lines / 10;
        if (level != supposedLevel) {
            updateLevel(supposedLevel);
        }
    }

    /**
     * On met à jour le level du jouer ainsi que le timer pour que le pièce
     * tombe plus vite en suivant une courbe exponentielle.
     */
    private void updateLevel(int supposedLevel) {
        level = supposedLevel;
        if (level <= 29) {
            double newDelay = 0.8 * Math.exp(-0.133 * level) * 1000;
            t.setDelay((int) newDelay);
        }
    }

    /**
     * Regarde si la ligne 21 contient une pièce, si tel est le cas, la partie
     * prend fin.
     */
    void checkGameOver() {
        for (int x = 0; x < gr.length; x++) {
            if (gr[x][1].isFilled()) {
                t.stop();
            }
        }
    }

    /**
     * Permet de recommencer une nouvelle partie.
     */
    public void restart() {
        for (int y = 0; y < gr[0].length; y++) {
            for (int x = 0; x < gr.length; x++) {
                gr[x][y] = new Case();
            }
        }
        level = 0;
        setLevel();
        lines = 0;
        setLines();
        score = 0;
        setScore();
        s.nextShape();
        paintBoard();
        t.restart();
    }

    /**
     * Update le score dans la JFrame.
     *
     * @param champScore Champ de texte de la JFrame
     */
    void setChampScore(JLabel champScore) {
        this.champScore = champScore;
    }

    /**
     * Update le level dans la JFrame.
     *
     * @param champLevel Champ de texte de la JFrame
     */
    void setChampLevel(JLabel champLevel) {
        this.champLevel = champLevel;
    }

    /**
     * Update les lignes dans la JFrame.
     *
     * @param champLines Champ de texte de la JFrame
     */
    void setChampLines(JLabel champLines) {
        this.champLines = champLines;
    }

    /**
     * Met à jour l'affichage du score
     */
    private void setScore() {
        champScore.setText(""+score);       
    }
    
    /**
     * Met à jour l'affichage des lignes
     */
    private void setLines() {
        champLines.setText(""+lines);
    }
    
    /**
     * Met à jour l'affichage du level
     */
    private void setLevel() {
        champLevel.setText(""+level);
    }

}

//=============================================================================//
class Case {

    Color c = Color.WHITE;
    boolean filled;
    
    /**
     * Focntion qui dessine notre case
     * @param x abscisse
     * @param y ordonnée
     * @param g Graphique
     * @param ech Echelle de la classe Dimension
     */
    public void dessineToi(int x, int y, Graphics g, Dimension ech) {
        g.setColor(c);
        g.fillRect(x * ech.width, y * ech.height, ech.width, ech.height);
        g.setColor(Color.BLACK);
        g.drawRect(x * ech.width, y * ech.height, ech.width, ech.height);
    }

    /**
     * Remplie une case.
     *
     * @param c Couleur de remplissage
     */
    public void fill(Color c) {
        filled = true;
        this.c = c;
    }

    /**
     * Permet de savoir si une case est remplie.
     *
     * @return True si la case est remplie, false sinon
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Retourne la couleur de la case
     *
     * @return Couleur de la case
     */
    public Color getColor() {
        return c;
    }

    /**
     * Vide une case.
     */
    public void setUnfilled() {
        filled = false;
    }

    /**
     * Vide une case et remplace sa couleur par celle passée en paramètre.
     *
     * @param c Couleur de la case
     */
    public void setUnfilled(Color c) {
        filled = false;
        this.c = c;
    }
}
