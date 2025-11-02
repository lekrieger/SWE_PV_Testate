
public class Cafe {

    public static void main(String[] args) {

        IcedTea icedTea = new IcedTea();
        Coffee coffee = new Coffee();
        Drink espresso = new Coffee();
        Drink lemon = icedTea;

        System.out.println("1: coffee.temperature           		: " + coffee.temperature);
        // Ausgabe der (Klassen-)Variable (Wert der Variable) temperature der Instanz "coffee" aus der Klasse Coffee

        System.out.println("2: icedTea.getTemperature()     		: " + icedTea.getTemperature());
        // Ausgabe des Rückgabewertes mittels Getter der Methode getTemperature() der Instanz "icedTea" aus der Klasse IcedTea
        
        System.out.println("3: coffee.getTemperature()      		: " + coffee.getTemperature());
        // Ausgabe des Rückgabewertes mittels Getter der Methode getTemperature() der Instanz "coffee" aus der Klasse Coffee
        
        System.out.println("4: ((IcedTea) lemon).temperature		: " + ((IcedTea) lemon).temperature);
        // Ausgabe der (Klassen-)Variable (Wert der Variable) temperature der Instanz "lemon", gecastet in die Klasse IcedTea
        // Upcast: die Referenzvariable lemon hat statischen Typ Drink, zeigt aber zur Laufzeit auf das IcedTea‑Objekt
        // eine Referenz auf das gleiche IcedTea‑Objekt, das mit new IcedTea() erstellt wurde
        
        System.out.println("5: ((Drink) coffee).temperature 		: " + ((Drink) coffee).temperature);
        // Ausgabe der (Klassen-)Variable (Wert der Variable) temperature der Instanz "coffee", gecastet in die Klasse Drink
        // Variablen der Superklasse / Elternklasse werden nicht überschrieben, daher wird der Wert der Klasse Drink ausgegeben
        // bedeutet also, dass eine Instanz der Klasse Coffee erstellt wird mit dem Konstruktor der Klasse Drink
        
        System.out.println("6: ((Drink) espresso).getTemperature()	: " + ((Drink) espresso).getTemperature());
        // Ausgabe des Rückgabewertes mittels Getter der Methode getTemperature() der Instanz "espresso", gecastet in die Klasse Drink
        
        System.out.println("7: Ist dieser Cast möglich? icedTea = (IcedTea)((Drink)coffee);");
        // Nein, da coffee eine Instanz der Klasse Coffee ist und nicht der Klasse IcedTea

    }
}