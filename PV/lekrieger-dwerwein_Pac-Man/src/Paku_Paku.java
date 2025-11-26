import javax.swing.*;

//Test 

public class Paku_Paku {
    public static void main(String[] args) throws Exception {
        
        Grid<GameObject> grid = new Grid<>(20, 20); // Grid mit 20x20 Zellen erstellen
        GamePanel gamePanel = new GamePanel(grid); // GamePanel mit dem Grid erstellen
        JFrame frame = new JFrame("Paku Paku"); // JFrame erstellen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel); // GamePanel zum JFrame hinzufügen
        frame.pack(); // JFrame auf bevorzugte Größe setzen
        frame.setVisible(true); // JFrame sichtbar machen

        Grid<GameObject> loadedGrid = LevelLoader.loadLevel("level1.txt");
        gamePanel = new GamePanel(loadedGrid);
        frame.add(gamePanel);
        frame.pack();
        frame.repaint();
    }
}
