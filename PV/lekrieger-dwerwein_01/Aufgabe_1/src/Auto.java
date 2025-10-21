package Aufgabe_1.src;

public class Auto extends Fahrzeug  {

    protected int PS;
    protected String marke;

    public Auto(String farbe, int geschwindigkeit, int avg_preis, int PS, String marke) {
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
        this.avg_preis = avg_preis;
        this.PS = PS;
        this.marke = marke;
    }
}

