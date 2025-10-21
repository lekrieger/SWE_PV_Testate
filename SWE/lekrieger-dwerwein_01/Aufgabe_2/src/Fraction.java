public class Fraction {

    private int zaehler; 
    private int nenner ; 

    public Fraction(int zaehler, int nenner) {

        if (nenner == 0) {
            System.out.println("Nenner darf niemals 0 sein!");
            return;
        }

        //Math.abs entfernt einfach das Vorzeichen bzw. macht einen positiven Betrag daraus
        int gT = größterTeiler(Math.abs(zaehler), Math.abs(nenner));

        // Vorzeichen beachten, stellt sicher, dass das - im Zähler steht und Nenner immer positiv ist
        if (nenner < 0) {
            this.zaehler = -zaehler / gT;
            this.nenner = -nenner / gT;
        } 
        else {
            this.zaehler = zaehler / gT;
            this.nenner = nenner / gT;
        }
    }

    //Bruch aus Ganzzahl erzeugen (1 als Nenner)
    public Fraction(int Ganzzahl) {

        this(Ganzzahl, 1); //Verkettung, Aufruf des Hauptkonstuktors
    }

    public int getZaehler() {
        return zaehler;
    }

    public int getNenner() {
        return nenner;
    }


    // multipliziere mit Ganzzahl (int)
    // Datentyp Fraction (kein int etc.)
    public Fraction multiply(int faktor) {
        return new Fraction(this.zaehler * faktor, this.nenner);
    }

    // multipliziere mit einem anderen Bruch (Datentyp "Fraction") 
    public Fraction multiply(Fraction faktor) {
        return new Fraction(this.zaehler * faktor.zaehler, this.nenner * faktor.nenner);
    }


    public Fraction divide(Fraction divisor) {
        // Division durch einen Bruch = Multiplikation mit dem Kehrwert
        return new Fraction(this.zaehler * divisor.nenner, this.nenner * divisor.zaehler);
    }

    // "..." bedeutet beliebige Anzahl an Argumenten möglich
    public Fraction multiply(Fraction... faktoren) {
        Fraction result = this;  // Variable namens result mit Datentyp Fraction wird erstellt, Startwert ist die erste Eingabe des Bruches
        for (Fraction i : faktoren) {
            result = result.multiply(i);
        }
        return result;
    }


    private int größterTeiler(int a, int b) {
        return b == 0 ? a:größterTeiler(b, a % b);
    }

    @Override
    public String toString() {
        return zaehler + "/" + nenner;
    }


}








