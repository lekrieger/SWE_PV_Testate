
public class Main {
    public static void main(String[] args) {
        Rechner rechner = new Rechner();
        int summe = rechner.addiere(5, 7);

        System.out.println("Test: addiere(5, 7) = " + summe);

        if (summe == 12) {
            System.out.println("Der Test war erfolgreich!");
        } else {
            System.out.println("Der Test ist fehlgeschlagen.");
        }

    }
}
