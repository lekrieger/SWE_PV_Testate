import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;

public class Paku_Paku {

    
    public static void main(String[] args) throws Exception {
        
        // System.out.println("aktueller Pfad: " + new java.io.File(".").getAbsolutePath());

        // JFrame vorbereiten
        JFrame window = new JFrame("Paku Paku");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true); // Feste Größe 

        try {
            // Level laden
            Grid<GameObject> grid = LevelLoader.loadLevel("PV/lekrieger-dwerwein_Pac-Man/Levels/level2.txt");

            // Panel erstellen und Grid übergeben
            GamePanel panel = new GamePanel(grid);

            window.add(panel);
            window.pack(); // Fenstergröße passt sich automatisch an das Panel (Grid * 20px) an
            window.setLocationRelativeTo(null); // zentriert das Fenster

            window.addKeyListener(new KeyAdapter() { // Tastatureingaben abfangen
                
                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        if (e.getKeyCode() == KeyEvent.VK_UP) {
                            grid.move(0, -1);
                        } 
                        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            grid.move(0, 1);
                        } 
                        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                            grid.move(-1, 0);
                        } 
                        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                            grid.move(1, 0);
                        }
                    } 
                    catch (InvalidMoveException ime) {
                    System.out.println("Bong!");
                    };

                    panel.repaint(); // Panel neu zeichnen, damit die Bewegung sichtbar wird
                }
            });

            window.setVisible(true);

            GameLoop loop = new GameLoop(grid, panel); // GameLoop erstellen
            Thread gameThread = new Thread(loop); // neuen Thread für die GameLoop erstellen
            gameThread.start();

        } 
        catch (IOException e) {
            // Fehlerbehandlung
            System.err.println("error: Level-Datei konnte nicht geladen werden");
            e.printStackTrace();
        }
    }
}

