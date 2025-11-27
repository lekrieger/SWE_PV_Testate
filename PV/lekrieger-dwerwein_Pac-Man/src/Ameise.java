public class Ameise implements Runnable {

    private Grid<GameObject> grid;
    private int x;
    private int y;
    private int steps;

    public Ameise(Grid<GameObject> grid, int startX, int startY, int steps) {
        this.grid = grid;
        this.x = startX;
        this.y = startY;
        this.steps = steps;

    }

    @Override
    public void run() {

        // Array für alle Richtungen: Oben, Rechts, Unten, Links
        int[][] richtungen = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
        java.util.ArrayList<Ameise> neueAmeisen = new java.util.ArrayList<>();

        for (int[] richtung : richtungen) {
            int newX = x + richtung[0];
            int newY = y + richtung[1];

            if (grid.setStepIfShorter(newY, newX, steps + 1)) {
                Ameise neueAmeise = new Ameise(grid, newX, newY, steps + 1);
                neueAmeisen.add(neueAmeise);
            }
            
            Thread ameisenThread = new Thread(neueAmeise);
            ameisenThread.start();
            
        }
    }
}
