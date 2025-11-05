import java.util.*;

public class ZooApp {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        zoo.addAnimal(new Animal(5, "Bär"));
        zoo.addAnimal(new Animal(2, "Affe"));
        zoo.addAnimal(new Animal(3, "Elefant"));
        zoo.addAnimal(new Animal(4, "Zebra"));


        List<Animal> tiereNachAlter = new ArrayList<>(zoo.tiere);
        tiereNachAlter.sort(new AnimalAgeComparator());
        System.out.println("Tiere sortiert nach Alter:");
        for (Animal a : tiereNachAlter) {
            System.out.println(a);
            // nach Alter sortieren, a = Liste der Tiere
        }
        System.out.println("\nAlphabetisch sortierte Tiere:");
        for (Animal a:zoo) {
            System.out.println(a);
            // alphabetisch sortieren
        }
    }
}