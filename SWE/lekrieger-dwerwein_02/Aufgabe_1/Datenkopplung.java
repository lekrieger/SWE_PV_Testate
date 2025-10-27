// Die Klasse Rechner ist von Datenkopplung über integer abhängig
// lose Kopplungsart, da Module Daten nur über Parameter austauschen


class Rechner {

    // Die Methode 'add' erhält ausschließlich die Daten (a und b), 
    // die sie für ihre  Operation benötigt
    public int add(int a, int b) {
        return a + b;
    }
}


public class Datenkopplung {
    public static void main(String[] args) {
        Rechner meinRechner = new Rechner();
        
        int summe = meinRechner.add(5, 10); 
        
        System.out.println("Die Summe ist: " + summe);
    }
}


// die main-Methode übergibt dem Rechner ausschließlich primitive Datenwerte (int a, int b), die zur Berechnung benötigt werden
// somit werden Daten verarbeitet = Datenkopplung