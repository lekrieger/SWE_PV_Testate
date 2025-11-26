import javax.swing.JPanel;
import java.awt.Dimension;

public class GamePanel extends JPanel {
    
    private Grid<GameObject> grid; // Variable anlegen für das Grid

    public GamePanel(Grid<GameObject> grid) {
        this.grid = grid;
        setPreferredSize(new Dimension(grid.getCols() * 20, grid.getRows() * 20));
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g); // Hintergrund vorher löschen
        grid.draw(g); // Das Grid zeichnet alle GameObjects
    }
}
