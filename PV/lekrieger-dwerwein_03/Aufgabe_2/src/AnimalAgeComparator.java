import java.util.Comparator;
// Java Comparator zum Vergleichen von Tieren nach Alter

public class AnimalAgeComparator implements Comparator<Animal> {
    
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.alter - a2.alter;
        // Tiere nach Alter aufsteigend sortieren
    }
}