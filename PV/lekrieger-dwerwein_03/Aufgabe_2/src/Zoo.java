import java.util.*;

public class Zoo implements Iterable<Animal> {

    List<Animal> tiere = new ArrayList<>();
    // Liste zur Speicherung der Tiere im Zoo

    public void addAnimal(Animal a) {
        tiere.add(a);
        // Tiere zur Liste hinzufügen
    }

    @Override
    public Iterator<Animal> iterator() {
        List<Animal> sortierteTiere = new ArrayList<>(tiere);
        
        sortierteTiere.sort(Comparator.comparing(a -> a.name));
        // Tiere nach Name sortieren
        
        return sortierteTiere.iterator();
        // Iterator über die sortierte Liste zurückgeben
    }

}
