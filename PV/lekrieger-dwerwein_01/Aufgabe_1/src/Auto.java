public class Auto extends Fahrzeug  {

    protected int PS;
    protected String marke;

    public Auto(String farbe, int geschwindigkeit, int avg_preis, int PS, String marke) {
        super(farbe, geschwindigkeit, avg_preis);
        this.PS = PS;
        this.marke = marke;
    }


}

