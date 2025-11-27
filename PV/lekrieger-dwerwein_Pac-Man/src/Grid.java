public class Grid<T extends GameObject> extends GameObject {
    // T als generischer Typ, der von GameObject erbt
    // T als Plathalter für alle GameObject-Typen (z.B. Ghost, Player, Wall, Dot, PowerUp)
    // Grid selbst ist ein GameObject

    // Attribute
    private T[][] spielfeld; // 2D-Array (Gitter) von Zellen des Typs T
    private int rows;   // Anzahl der Reihen im Grid
    private int cols;   // Anzahl der Spalten im Grid
    private T player; // Referenz auf das Player-Objekt im Grid

    // Konstruktor
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        // Initialisierung des 2D-Arrays / Spielfelds
        spielfeld = (T[][]) new GameObject[rows][cols];
    }

    // Getter für rows und cols
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
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

    @Override
    public synchronized void update() { //public, damit alle Klassen die Methode aufrufen können
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
    protected synchronized void move() {
        // Logik zur Bewegung des Grids, falls erforderlich
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
    public synchronized void movePlayer(int deltaX, int deltaY) throws InvalidMoveException {
        int targetX = this.player.x + deltaX;
        int targetY = this.player.y + deltaY;

        T targetObj = getCell(targetY, targetX);
        if (targetObj instanceof Wall) {    // Kollision mit Wand
            throw new InvalidMoveException("Bong!");
        } 
        else {
            // Player an die neue Position bewegen
            setCell(this.player.y, this.player.x, null); // alte Position leeren
            this.player.x = targetX;
            this.player.y = targetY;
            setCell(targetY, targetX, this.player); // Player an neuer Position setzen
        }
    }

}

