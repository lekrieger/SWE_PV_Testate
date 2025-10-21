package Aufgabe_1.src;

public class Fahrrad extends Fahrzeug{

    protected int ganganzahl;
    protected String typ; // z.B. Mountainbike

    public Fahrrad(String farbe, int geschwindigkeit, int avg_preis, int ganganzahl, String typ) {
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
        this.avg_preis = avg_preis;
        this.ganganzahl = ganganzahl;
        this.typ = typ;
    }
}
