import java.io.*;
// importieren für IOExceptions

public class ExceptionHandler {
    public static void main(String[] args) {
        ExceptionHandler e = new ExceptionHandler();
        System.out.println("--------- Getrennte Catch-Blöcke ---------");
        e.handleExceptionsSeperatly();
        System.out.println("--------- Multi Catch-Block ---------");
        e.handleExceptionsWithMultiCatch();
    }

    public void handleExceptionsSeperatly() {
        try {
            throw new IOException("Dateifehler!");
            // throw new NumberFormatException("Zahlenformatfehler!");
            // throw new NullPointerException("Nullzeigerfehler!");
        } catch (IOException e) {
            System.out.println("IOException gefangen: " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException gefangen: " + e.getMessage());
            e.printStackTrace();
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException gefangen: " + e.getMessage());
            e.printStackTrace();
        }
        // e.getMessage() gibt die Fehlermeldung zurück
    }

    public void handleExceptionsWithMultiCatch() {
        try {
            throw new NumberFormatException("Zahlenformatfehler!");
            // IOException("Dateifehler!");
            // NullPointerException("Nullzeigerfehler!");
        } catch (NullPointerException | NumberFormatException e) {
        // IOException wird hier nicht hinzugefügt da sonst Compile Error
            System.out.println("Exception gefangen: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            e.printStackTrace();
        }
        // e.getClass().getSimpleName() gibt den Namen der Ausnahme zurück  
    }
}