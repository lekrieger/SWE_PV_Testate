import java.io.IOException;

import javax.swing.*;

public class Paku_Paku {

    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Ich suche in: " + new java.io.File(".").getAbsolutePath());
        // JFrame vorbereiten
        JFrame window = new JFrame("Paku Paku");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // Feste Größe 

        try {
            // Level laden
            Grid<GameObject> grid = LevelLoader.loadLevel("PV/lekrieger-dwerwein_Pac-Man/Levels/level1.txt");

            // Panel erstellen und Grid übergeben
            GamePanel panel = new GamePanel(grid);

            window.add(panel);
            window.pack(); // Fenstergröße passt sich automatisch an das Panel (Grid * 20px) an
            window.setLocationRelativeTo(null); // zentriert das Fenster
            window.setVisible(true);

        } catch (IOException e) {
            // Fehlerbehandlung
            System.err.println("FEHLER: Konnte Level-Datei nicht laden!");
            e.printStackTrace();
        }
    }
}

