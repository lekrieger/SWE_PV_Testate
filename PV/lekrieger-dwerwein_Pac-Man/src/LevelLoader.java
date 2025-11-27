import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LevelLoader {    
    
    // liest Level-Datei (String path) und erstellt daraus das Spielfeld als Grid<GameObject>
    public static Grid<GameObject> loadLevel(String path) throws IOException {

        // öffnet die Datei zum Lesen
        // BufferedReader liest effizient ganze Zeilen auf einmal 
        BufferedReader br = new BufferedReader(new FileReader(path));

        // speichert temporär aktuelle Zeile
        String line; 
        // Liste aller Zeilen
        List<String> lines = new ArrayList<>(); 

        // Zeile lesen, in "line" speichern und prüfen, dass != null
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        
        // Höhe = Anzahl eingelesener Zeilen
        int height = lines.size();
        // Breite = Länge der allerersten Zeile
        int width = lines.get(0).length();

        Grid<GameObject> grid = new Grid<>(height, width);

        // durch alle Zeilen iterieren
        for (int y = 0; y < height; y++) {
            String currentLine = lines.get(y);
            // durch alle Zeichen der aktuellen Zeile iterieren
            for (int x = 0; x < width; x++) {
                char c = currentLine.charAt(x); // aktuelles Zeichen an Position x holen
                GameObject obj;

                // je nach Zeichen ein entsprechendes GameObject erstellen
                // springt sofort in den passenden case-Block
                switch (c) {
                    case '#':
                        obj = new Wall();
                        break;
                    case '.':
                        obj = new Dot();
                        break;
                    case 'P':
                        obj = new Player();
                        break;
                    case 'G':
                        obj = new Ghost();
                        break;
                    default:
                        obj = null; // leere Zelle
                        break;
                }

                // GameObject im Grid an der Position (x, y) speichern
                grid.setCell(y, x, obj);
            }
        }     
        return grid;
    }
}
