public class Grid<T extends GameObject> extends GameObject {
    // T als generischer Typ, der von GameObject erbt
    // T als Plathalter für alle GameObject-Typen (z.B. Ghost, Player, Wall, Dot, PowerUp)
    // Grid selbst ist ein GameObject

    // Attribute
    private T[][] spielfeld; // 2D-Array (Gitter) von Zellen des Typs T
    private int rows;   // Anzahl der Reihen im Grid
    private int cols;   // Anzahl der Spalten im Grid
    private T player; // Referenz auf das Player-Objekt im Grid
    private int score = 0; // Punktestand
    private int highscore = 0; // Höchster Punktestand
    private int totalDots = 0; // Gesamtanzahl der Punkte im Level
    private int nextDeltaX = 0; // nächste X-Richtung für den Player
    private int nextDeltaY = 0; // nächste Y-Richtung für den Player
    private volatile boolean isRunning = true; // Spiel läuft oder nicht
    private boolean levelCompleted = false; // Flag für Sieg
    private int playerMoveCounter = 0;
    private final int player_speed = 2; // 1 = schnell, 2 = normal, 3 = langsam

    // 2D-Array (so groß wie das Spielfeld) zur Speicherung der Schrittanzahl für Ameisen
    // Ameisen schreiben, wie viele Schritte sie zu dieser Zelle gebraucht haben
    // 0 = noch nicht besucht
    private int[][] stepCount; 

    // Konstruktor
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        // Initialisierung des 2D-Arrays / Spielfelds
        spielfeld = (T[][]) new GameObject[rows][cols];

        // Initialisierung des Schrittzählers für Ameisen
        // merkt sich Koordinaten und die dazugehörige Schrittzahl
        stepCount = new int[rows][cols]; 
    }

    // Getter für rows und cols
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public boolean isLevelCompleted() {
        return levelCompleted;
    }

    // beim Setter das zu übergebende Objekt im 2D-Array speichern
    // synchronized, damit nur ein Thread gleichzeitig auf die Methode zugreifen kann
    public synchronized void setCell(int row, int col, T obj) {
        spielfeld[row][col] = obj;

        if (obj != null) {
            obj.x = col; 
            obj.y = row;

            if (obj instanceof Player) {
                this.player = obj; // Player-Referenz speichern
            }
        }        
    }
    public synchronized T getCell(int row, int col) {
        return spielfeld[row][col];
    }

    // Aktuellen Punktestand holen
    public int getScore() {
        return score;
    }

    // Aktuellen Highscore setzen
    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    // Aktuellen Highscore holen
    public int getHighscore() {
        return highscore;
    }

    // Gesamtanzahl der Punkte im Level setzen
    public void setTotalDots(int totalDots) {
        this.totalDots = totalDots;
    }

    // Prüfen, ob das Spiel noch läuft
    public boolean isRunning() {
        return isRunning;
    }

    // Spiel stoppen
    public void stopGame() {
        this.isRunning = false;
    }

    public void setNextDirection(int deltaX, int deltaY) {
        this.nextDeltaX = deltaX;
        this.nextDeltaY = deltaY;
    }

    public void tryMovePlayer() throws GameOverException {
        if (nextDeltaX != 0 || nextDeltaY != 0) {
            try {
                movePlayer(nextDeltaX, nextDeltaY);
            } 
            catch (InvalidMoveException ime) {
                this.nextDeltaX = 0;
                this.nextDeltaY = 0;
            }
        }
    }

    @Override
    public void update() throws GameOverException { //public, damit alle Klassen die Methode aufrufen können

        playerMoveCounter++;
        if (playerMoveCounter >= player_speed) {
            tryMovePlayer(); // Spielerbewegung versuchen
            playerMoveCounter = 0;
            }
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                T obj = spielfeld[row][col];
                if (obj != null) { // nur wenn ein Objekt in der Zelle ist
                    obj.update(); // Jedes Objekt darf seine Logik ausführen
                }
            }
        }
    }

    @Override
    protected synchronized void draw(java.awt.Graphics g) {
        
        for (int row = 0; row < rows; row++) { // doppelte Schleife, geht Zeile für Zeile von links nach rechts durch
            for (int col = 0; col < cols; col++) {
                T obj = spielfeld[row][col]; // aktuelles GameObject im Grid holen
                if (obj != null) { // wenn ein Objekt null ist (z.B. leere Zelle), wird es nicht gezeichnet
                    obj.draw(g); // jedes GameObject im Grid zeichnet sich selbst
                }
            }
        }
    }

    // Methode zur Bewegung des Players im Grid
    public synchronized void movePlayer(int deltaX, int deltaY) throws InvalidMoveException, GameOverException {
        int targetX = this.player.x + deltaX;
        int targetY = this.player.y + deltaY;

        T targetObj = getCell(targetY, targetX);
        if (targetObj instanceof Wall) {    // Kollision mit Wand
            throw new InvalidMoveException("Bong!");
        }
        else if (targetObj instanceof Ghost) {
            // Exception fliegt zum KeyListener
            throw new GameOverException("GAME OVER: In Geist gelaufen!");
        }
        else if (targetObj instanceof Dot) {
            score += 10; // Punktestand erhöhen
            setCell(this.player.y, this.player.x, null); // alte Position leeren
            this.player.x = targetX;
            this.player.y = targetY;
            setCell(targetY, targetX, this.player); // Player an neuer Position setzen

            // Punkt wurde eingesammelt, Level abgeschlossen
            if (this.score == this.totalDots * 10) {
                System.out.println("Level abgeschlossen! Endpunktestand: " + this.score);

                // Highscore prüfen und ggf. aktualisieren
                if (this.score > this.highscore) {
                    this.highscore = this.score;
                    System.out.println("Neuer Highscore: " + this.highscore);
                }
                this.levelCompleted = true;
                stopGame(); // Spiel stoppen
            }
        }
        else {

            setCell(this.player.y, this.player.x, null); // alte Position leeren
            this.player.x = targetX;
            this.player.y = targetY;
            setCell(targetY, targetX, this.player); // Player an neuer Position setzen
        }
    }

    // Schritte der Ameise auf 0 zurücksetzen, um neue Berechnung zu starten
    public synchronized void resetSteps() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                stepCount[y][x] = 0;
            }
        }
    }

    public synchronized boolean setStepIfShorter(int y, int x, int steps) {
        // testen, ob das Feld im Grid ist
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
            return false;
        }       

        // schaut, ob die Zelle des Spielfelds eine Wand ist
        if (spielfeld[y][x] instanceof Wall) {
            return false;
        }
        
        // 0 = noch nicht besucht
        // wenn noch nicht besucht, dann Schrittanzahl setzen
        // stepCount = Speicher bzw bisheriger Wert
        // currentSteps kopiert von stepCount
        // kürzerer Weg, wenn eigene steps < currentSteps
        // wenn Weg kürzer ist, wird stepCount von den eigenen steps überschrieben
        int currentSteps = stepCount[y][x];
        if (currentSteps == 0 || steps < currentSteps) {
            stepCount[y][x] = steps;
            return true; // kürzerer Weg gefunden
        }       
        return false; // Ameise stirbt
    }

    public synchronized int getStep(int y, int x) {
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
                return 0;
            }
        return stepCount[y][x];
    }

}

