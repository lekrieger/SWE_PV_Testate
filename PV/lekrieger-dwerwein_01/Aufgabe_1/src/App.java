package Aufgabe_1.src;

public class App {
    public static void main(String[] args) {
        

        Fahrrad f1 = new Fahrrad("Rot", 25, 300, 21, "Mountainbike"); 
        Auto a1 = new Auto("Blau", 120, 20000, 150, "BMW");

        f1.bewegen();
        a1.bewegen();

        System.out.println("Fahrrad Details:\nFarbe: " + f1.farbe + "\nGeschwindigkeit: " + f1.geschwindigkeit + " km/h\nDurchschnittspreis: " + f1.avg_preis + " EUR\nGanganzahl: " + f1.ganganzahl + "\nTyp: " + f1.typ);
        System.out.println("Auto Details:\nFarbe: " + a1.farbe + "\nGeschwindigkeit: " + a1.geschwindigkeit + " km/h\nDurchschnittspreis: " + a1.avg_preis + " EUR\nPS: " + a1.PS + "\nMarke: " + a1.marke);

    }
}
