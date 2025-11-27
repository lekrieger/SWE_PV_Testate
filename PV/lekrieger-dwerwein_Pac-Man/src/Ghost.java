import java.awt.*;

public class Ghost extends GameObject {

    private Grid<GameObject> grid;
    private int moveCounter = 0;

    // Setter, um das Grid dem Levelloader zu übergeben 
    public void setGrid(Grid<GameObject> grid) {
        this.grid = grid;
    }

    @Override
    protected void draw(Graphics g) {
        g.setColor(new Color(148, 0, 211));
        
        int s = GamePanel.scale; 
        g.fillRect(x * s + s/10, y * s + s/10, s * 4/5, s * 4/5);
    }

    @Override
    protected void update() {
        if (grid == null) return; // Sicherheits-Check

        // Cooldown, nur alle 5 Updates bewegen, sonst Geister zu schnell
        moveCounter++;
        if (moveCounter < 5) { 
            return; 
        }
        moveCounter = 0; 

        // Spielfeld zurücksetzen (alte Zahlen löschen)
        grid.resetSteps();

        // erste Ameise beim Geist starten
        // starten bei (x, y) mit dem Wert 1 (0 = unbesucht)
        Ameise hauptAmeise = new Ameise(grid, this.x, this.y, 1);
        Thread t = new Thread(hauptAmeise);
        t.start();

        try {
            // warten bis die Haupt-Ameise und Kinder fertig sind
            t.join();
        } 
        catch (InterruptedException e) {
                e.printStackTrace();
            }

        // Grid jetzt voller Zahlen, jetzt Weg suchen
        move();
    }

    @Override
    protected void move() {
        // Position des Spielers im Grid suchen
        GameObject player = null;
        for(int r=0; r<grid.getRows(); r++) {
            for(int c=0; c<grid.getCols(); c++) {
                if (grid.getCell(r, c) instanceof Player) {
                    player = grid.getCell(r, c);
                }
            }
        }

        if (player == null) return; // nicht gefunden

        // beim Spieler starten und das Feld mit der kleinsten Nummer suchen, bis Geist erreicht
        int zielX = player.x;
        int zielY = player.y;
        int currentDist = grid.getStep(zielY, zielX);

        // Spieler nicht erreicht; abbrechen
        if (currentDist == 0) {
            return;
        }

        // Rückwärts-Suche: vom Spieler so lange zum Nachbarn mit currentDist - 1, bis Abstand = 2 = Nachbar vom Geist
        while (currentDist > 2) {
            // Nachbarn checken (Oben, Rechts, Unten, Links)
            int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
            boolean foundNeighbor = false;
            
            for (int[] d : dirs) {
                int nx = zielX + d[0];
                int ny = zielY + d[1];

                if (nx < 0 || nx >= grid.getCols() || ny < 0 || ny >= grid.getRows()) continue;
                int nDist = grid.getStep(ny, nx);

                // Vorgänger gefunden? ein Schritt weniger
                if (nDist > 0 && nDist == currentDist - 1) {
                    zielX = nx;
                    zielY = ny;
                    currentDist = nDist;
                    foundNeighbor = true; // Weg gefunden
                    break;
                }
            }

            if (!foundNeighbor) {
                // kein Nachbar gefunden, Abbruch
                return;
            }
        }

        // zielX und zielY  jetzt das Feld direkt neben dem Geist, das zum Spieler führt        
        // Im Grid aktualisieren 
        grid.setCell(this.y, this.x, null); // altes Feld leeren
        this.x = zielX;
        this.y = zielY;
        grid.setCell(this.y, this.x, this); // auf neues Feld setzen
    }
}
