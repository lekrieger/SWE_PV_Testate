public class GameLoop implements Runnable {

    private Grid<GameObject> grid;
    private GamePanel panel;

    public GameLoop(Grid<GameObject> grid, GamePanel panel) {
        this.grid = grid;
        this.panel = panel;
    }

    public void run() {

        // Endlosschleife für das Spiel, bis running auf false (GameOver) gesetzt wird
        while (grid.isRunning() == true) {
            grid.update(); // alle GameObjects im Grid updaten
            panel.repaint(); // GamePanel neu zeichnen / aktualisieren
            try {
                grid.update(); // alle GameObjects im Grid updaten
                panel.repaint(); // GamePanel neu zeichnen / aktualisieren
                Thread.sleep(100); // 100ms Pause zwischen den Updates, damit das Spiel nicht zu schnell läuft
            } 
            catch (GameOverException e) {
                System.out.println(e.getMessage());
                running = false; // Spiel beenden, wenn GameOverException geworfen
                // panel.showGameOverMessage();
            }               
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Paku_Paku.saveHighscore(grid.getHighscore()); // Highscore speichern, wenn das Spiel endet
    }
}
