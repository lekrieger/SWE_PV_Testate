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

        // Score und Highscore anzeigen
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + grid.getScore(), 10, 15); // Score anzeigen
        g.drawString("Highscore: " + grid.getHighscore(), 100, 15); // Highscore anzeigen

        // Prüfen, ob das Spiel vorbei ist
        if (!grid.isRunning()) {
            drawGameOver(g);
        }
    }

    // Game-Over-Screen
    private void drawGameOver(Graphics g) {
        // 
        g.setColor(new Color(0, 0, 0, 150)); // Schwarz mit Transparenz
        g.fillRect(0, 0, getWidth(), getHeight());

        // Text
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        String text = "GAME OVER";

        // Text zentrieren
        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        int y = getHeight() / 2;

        g.drawString(text, x, y);

       
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String scoreText = "Final Score: " + grid.getScore();
        String highscoreText = "Highscore: " + grid.getHighscore();
        int scoreX = (getWidth() - g.getFontMetrics().stringWidth(scoreText)) / 2;
        g.drawString(scoreText, scoreX, y + 40);
        int highscoreX = (getWidth() - g.getFontMetrics().stringWidth(highscoreText)) / 2;
        g.drawString(highscoreText, highscoreX, y + 70);
    }

}
