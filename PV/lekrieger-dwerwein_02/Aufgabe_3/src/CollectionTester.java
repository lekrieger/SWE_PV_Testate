// 4 Collections 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashSet; 

// Java Utilities
import java.util.List;
import java.util.Collection;

// Java Maps
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

// Laufzeit von Collections testen

public class CollectionTester {

    // Anzahl der Test-Elemente
    private static final int N = 100_000;

    public static void main(String[] args) {
        
        // 1. Die Liste der zu testenden Collections
        List<Collection<String>> collectionsToTest = List.of(
            new ArrayList<>(),
            new LinkedList<>(),
            new LinkedHashSet<>(),
            new HashSet<>()  
        );

        // 2. Generiere N einzigartige Test-Elemente
        List<String> testData = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            testData.add("Element_" + i);
        }

        // 3. Speicher für die Ergebnisse (LinkedHashMap behält die Reihenfolge)
        Map<String, Map<String, Double>> allResults = new LinkedHashMap<>();

        System.out.println("Starte Performance-Test mit N = " + N + " Elementen:");

        // 4. Test jeder Collection
        for (Collection<String> collection : collectionsToTest) {
            String collectionName = collection.getClass().getSimpleName();
            Map<String, Double> methodTimes = new HashMap<>();

            // TEST 1 : add(T)
            long startTimeAdd = System.nanoTime();
            for (String item : testData) {
                collection.add(item);
            }
            long endTimeAdd = System.nanoTime();
            // Durchschnittliche Zeit pro 'add'-Operation
            double avgTimeAdd = (double)(endTimeAdd - startTimeAdd) / N;
            methodTimes.put("add", avgTimeAdd);

            
            // TEST 2 : contains(T)
            long startTimeContains = System.nanoTime();
            for (String item : testData) {
                collection.contains(item);
            }
            long endTimeContains = System.nanoTime();
            // Durchschnittliche Zeit pro 'contains'-Operation
            double avgTimeContains = (double)(endTimeContains - startTimeContains) / N;
            methodTimes.put("contains", avgTimeContains);

            
            // TEST 3 : remove(T)
            long startTimeRemove = System.nanoTime();
            for (String item : testData) {
                collection.remove(item);
            }
            long endTimeRemove = System.nanoTime();
            // Durchschnittliche Zeit pro 'remove'-Operation
            double avgTimeRemove = (double)(endTimeRemove - startTimeRemove) / N;
            methodTimes.put("remove", avgTimeRemove);

            // Speichere die Ergebnisse für diese Collection
            allResults.put(collectionName, methodTimes);
        }
        
        // 5. Ergebnisse in einer Tabelle ausgeben
        printResultsTable(allResults);
    }

    // Gibt die gesammelten Ergebnisse formatiert als Tabelle aus.
     
    private static void printResultsTable(Map<String, Map<String, Double>> allResults) {
        System.out.println("--- Performance-Analyse (N = " + N + " Elemente) ---");
        System.out.println("Alle Zeiten sind DURCHSCHNITTLICHE Zeiten pro Operation in Nanosekunden (ns).\n");

        // Print Header
        System.out.printf("%-18s | %18s | %18s | %18s%n",
                          "Collection-Klasse", "add(T) [ns]", "contains(T) [ns]", "remove(T) [ns]");
        System.out.println(new String(new char[79]).replace('\0', '-'));

        // Print Data Rows
        for (Map.Entry<String, Map<String, Double>> entry : allResults.entrySet()) {
            String name = entry.getKey();
            double addTime = entry.getValue().get("add");
            double containsTime = entry.getValue().get("contains");
            double removeTime = entry.getValue().get("remove");

            System.out.printf("%-18s | %18.2f | %18.2f | %18.2f%n",
                              name, addTime, containsTime, removeTime);
        }
    }
}