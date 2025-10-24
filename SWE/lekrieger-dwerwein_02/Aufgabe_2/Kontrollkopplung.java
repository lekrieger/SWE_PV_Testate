class Drucker {

    // Parameter Großbuchstaben ist ein Kontrollparameter
    // Er bestimmt, wie sich die Methode intern verhalten soll, also welcher Fall genommen wird
    public void drucken(String text, boolean Großbuchstaben) {

        if (Großbuchstaben) {
            System.out.println(text.toUpperCase());
        } else {
            System.out.println(text.toLowerCase());
        }
    }
}


public class Kontrollkopplung {
    public static void main(String[] args) {
        Drucker meinDrucker = new Drucker();
        
        // Aufruf entscheidet über den Fall / Entscheidungsweg im Drucker
        meinDrucker.drucken("Hallo Welt", true); 
    }
}

// main-Methode übergibt den Parameter Großbuchstaben, der den Kontrollfluss (if/else) innerhalb der drucken-Methode steuert
// boolean-Wert wird nicht verabeitet (wie in int), sondern zur Steuerung des Programmablaufs genutzt, daher Kontrollkopplung und keine Datenkopplung