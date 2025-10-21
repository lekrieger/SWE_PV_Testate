public class Fahrrad extends Fahrzeug {

    protected int ganganzahl;
    protected String typ; // z.B. Mountainbike

    public Fahrrad(String farbe, int geschwindigkeit, int avg_preis, int ganganzahl, String typ) {
        super(farbe, geschwindigkeit, avg_preis);
        this.ganganzahl = ganganzahl;
        this.typ = typ;
    }


}
