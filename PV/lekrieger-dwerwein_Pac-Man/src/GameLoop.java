public class GameLoop implements Runnable {

    private Grid<GameObject> grid;
    private GamePanel panel;
    private boolean running = true;

    public GameLoop(Grid<GameObject> grid, GamePanel panel) {
        this.grid = grid;
        this.panel = panel;
    }

    public void run() {

        // Endlosschleife für das Spiel, bis running auf false (GameOver) gesetzt wird
        while (running == true) {
            grid.update(); // alle GameObjects im Grid updaten
            panel.repaint(); // GamePanel neu zeichnen / aktualisieren
            try {
                Thread.sleep(100); // 100ms Pause zwischen den Updates, damit das Spiel nicht zu schnell läuft
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
