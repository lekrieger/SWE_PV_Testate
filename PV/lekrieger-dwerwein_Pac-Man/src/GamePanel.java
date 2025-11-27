import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    
    private Grid<GameObject> grid; // Variable anlegen für das Grid
    public static final int scale = 20; // Skalierungsfaktor für die Größe der Zellen

    public GamePanel(Grid<GameObject> grid) {
        this.grid = grid;
        setPreferredSize(new Dimension(grid.getCols() * scale, grid.getRows() * scale)); // Größe des Panels basierend auf Grid-Größe (Skalierung der Levelgröße * scale Pixel pro Zelle)
        setBackground(Color.BLACK);
    }



    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g); // Hintergrund vorher löschen
        grid.draw(g); // Das Grid zeichnet alle GameObjects
    }
}
