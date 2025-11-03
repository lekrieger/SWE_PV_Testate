
public class Main {
    public static void main(String[] args) {
        Rechner rechner = new Rechner();
        int summe = rechner.addiere(5, 7);

        System.out.println("Test: addiere(5, 7) = " + summe);
        
        //Hier wird entschieden ob der Test erfolgreich sein fehlschlagen soll
        if (summe == 12) {
            System.out.println("Der Test war erfolgreich!");
        } else {
            System.out.println("Der Test ist fehlgeschlagen.");
            //Hier wird in GitHub Actions ein Fehlercode zurückgegeben
            System.exit(1);
        }
    }
}
