// Methode 'berechne' bündelt verschiedene, aber ähnliche (logische) Aktionen


class Rechnen {

    // Parameter ('operation') wählt den if-Zweig aus
    public void berechne(int operation, int a, int b) {
        
        if (operation == 1) { 
            // 1. Addition
            System.out.println("Summe aus: " + a + " + " + b + " = " + (a + b));
            System.out.println();
        } 
        else if (operation == 2) {
            // 2. Subtraktion
            System.out.println("Differenz aus: " + a + " - " + b + " = " + (a - b));
        } 
        else {
            System.out.println("Unbekannte Operation.");
        }
    }
}

// Aufrufende Klasse
public class LogischeBindung {
    public static void main(String[] args) {
        Rechnen x = new Rechnen();
        
        // erster Parameter entscheidet, ob Addition oder Subraktion
        x.berechne(1, 10, 5); 
        x.berechne(2, 10, 5); 
    }
}

// logische, da die Aktionen (Addition, Subtraktion) thematisch zusammengehören
// Methode "berechne" führt verschiedene Operationen basierend auf dem operation-Parameter aus