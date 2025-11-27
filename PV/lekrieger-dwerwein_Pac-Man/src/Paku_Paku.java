import javax.swing.*;

public class Paku_Paku {
    public static void main(String[] args) throws Exception {
        
        Grid<GameObject> loadedGrid = LevelLoader.loadLevel("src/Levels/level1.txt"); //Grid aus Datei laden
        GamePanel gamePanel  = new GamePanel(loadedGrid);  // Neues GamePanel mit geladenem Grid erstellen
        JFrame frame = new JFrame("Paku Paku"); // JFrame erstellen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);   // Neues GamePanel zum JFrame hinzufügen
        frame.pack();   // JFrame auf bevorzugte Größe setzen
        frame.repaint();    // JFrame neu zeichnen
        frame.setVisible(true); // JFrame sichtbar machen
    }
}

