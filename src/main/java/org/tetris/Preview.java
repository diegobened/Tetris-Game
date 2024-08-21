package tetris;

/**
 * Import des modules utiles à la classe
 */
import java.awt.*;

public class Preview extends Canvas {
    Dimension ech = new Dimension();
    Shape s;
    
    /**
     * Constructeur
     * @param s Shape
     */
    Preview(tetris.Shape s) {
        this.s = s;
        s.setInPreview(this);
        repaint();
    }
    
    /**
     * Dessine la box de preview
     * @param g Graphique
     */
    public void paint(Graphics g) {
        ech.width = getWidth() / 5;
        ech.height = getHeight() / 5;
        s.showNextShapeInPreview(g, ech);
    }
}
