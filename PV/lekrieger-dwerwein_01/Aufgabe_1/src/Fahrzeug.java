public class Fahrzeug {

    protected String farbe;
    protected int geschwindigkeit;
    protected int avg_preis;


    public Fahrzeug(String farbe, int geschwindigkeit, int avg_preis) {
        this.farbe = farbe;
        this.geschwindigkeit = geschwindigkeit;
        this.avg_preis = avg_preis;
    }

    public void bewegen() {
        System.out.println("Das Fahrzeug bewegt sich.");
    }

}
