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
            Grid<GameObject> grid = LevelLoader.loadLevel("PV/lekrieger-dwerwein_Pac-Man/Levels/level1.txt");

            // Panel erstellen und Grid übergeben
            GamePanel panel = new GamePanel(grid);

            window.add(panel);
            window.pack(); // Fenstergröße passt sich automatisch an das Panel (Grid * 20px) an
            window.setLocationRelativeTo(null); // zentriert das Fenster

            int highscore = loadHighscore();
            grid.setHighscore(highscore);

            window.addKeyListener(new KeyAdapter() { // Tastatureingaben abfangen
                
                @Override
                public void keyPressed(KeyEvent e) {

                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        grid.setNextDirection(0, -1);
                    } 
                    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        grid.setNextDirection(0, 1);
                    } 
                    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        grid.setNextDirection(1, 0);
                    } 
                    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        grid.setNextDirection(1, 0);
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        saveHighscore(grid.getScore());
                    }

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

    // Methode zum Speichern des Highscores
    public static void saveHighscore(int score) {
        HighscoreData data = new HighscoreData();
        data.score = score;

        // Highscore in Datei speichern
        try (java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(new java.io.FileOutputStream("highscore.dat"))) {
            out.writeObject(data);
            System.out.println("Highscore gespeichert: " + score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int loadHighscore() {
    try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.FileInputStream("highscore.dat"))) {
        
        // 1. Objekt aus der Datei lesen und in Variable speichern
        HighscoreData data = (HighscoreData) in.readObject();
        return data.score;

    } catch (java.io.FileNotFoundException e) {
        // Datei existiert nicht -> Erster Start
        return 0; 

    } catch (java.io.IOException | ClassNotFoundException e) {
        // Lese- oder Formatfehler
        System.err.println("FEHLER: Highscore-Datei beschädigt.");
        return 0; 
    }
}
}

