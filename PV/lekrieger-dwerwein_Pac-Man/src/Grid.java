public class Grid<T extends GameObject> extends GameObject {
    // T als generischer Typ, der von GameObject erbt
    // T als Plathalter für alle GameObject-Typen (z.B. Ghost, Player, Wall etc.)
    // Grid selbst ist ein GameObject

    private T[][] spielfeld; // 2D-Array (Gitter) von Zellen des Typs T
    private int rows;   // Anzahl der Reihen im Grid
    private int columns;   // Anzahl der Spalten im Grid

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        // Initialisierung des 2D-Arrays / Spielfelds
        spielfeld = (T[][]) new GameObject[rows][columns];
    }

    // beim Setter das zu übergebende Objekt im 2D-Array speichern
    public void setCell(int row, int column, T obj) {
        spielfeld[row][column] = obj;
    }
    public T getCell(int row, int column) {
        return spielfeld[row][column];
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
            for (int col = 0; col < columns; col++) {
                T obj = spielfeld[row][col]; // aktuelles GameObject im Grid holen
                if (obj != null) { // wenn ein Objekt null ist (z.B. leere Zelle), wird es nicht gezeichnet
                    obj.draw(g); // jedes GameObject im Grid zeichnet sich selbst
                }
            }
        }
    }

}

