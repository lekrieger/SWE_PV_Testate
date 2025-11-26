public class Grid<T extends GameObject> extends GameObject {
    // T als generischer Typ, der von GameObject erbt
    // T als Plathalter für alle GameObject-Typen (z.B. Ghost, Player, Wall etc.)
    // Grid selbst ist ein GameObject

    // Attribute
    private T[][] spielfeld; // 2D-Array (Gitter) von Zellen des Typs T
    private int rows;   // Anzahl der Reihen im Grid
    private int cols;   // Anzahl der Spalten im Grid

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
    public void setCell(int row, int col, T obj) {
        spielfeld[row][col] = obj;
    }
    public T getCell(int row, int col) {
        return spielfeld[row][col];
    }

    @Override
    public void update() { //public, damit alle Klassen die Methode aufrufen können
        // Logik zur Aktualisierung des Grids, falls erforderlich
    }

    @Override
    protected void move() {
        // Logik zur Bewegung des Grids, falls erforderlich
    }

    @Override
    protected void draw(java.awt.Graphics g) {
        
        for (int row = 0; row < rows; row++) { // doppelte Schleife, geht Zeile für Zeile von links nach rechts durch
            for (int col = 0; col < cols; col++) {
                T obj = spielfeld[row][col]; // aktuelles GameObject im Grid holen
                if (obj != null) { // wenn ein Objekt null ist (z.B. leere Zelle), wird es nicht gezeichnet
                    obj.draw(g); // jedes GameObject im Grid zeichnet sich selbst
                }
            }
        }
    }

}

