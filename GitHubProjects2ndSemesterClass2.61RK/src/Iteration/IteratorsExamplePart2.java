package Iteration;

import java.util.*;

public class IteratorsExamplePart2 {
    public static void main(String[] args) {
        // 1. Erstellen von 100 Objekten der Klasse SampleData
        List<SampleData> allData = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            String name = SampleData.generateRandomName(); // Generiert Namen aus der SampleData-Klasse
            allData.add(new SampleData(i, name));
        }

        // 2. Zufälliges Auswählen von 5 Objekten
        Collections.shuffle(allData); // Mische die Liste
        List<SampleData> randomFive = allData.subList(0, 5);

        // 3. Hinzufügen der Objekte zu verschiedenen Datenstrukturen
        List<SampleData> arrayList = new ArrayList<>(randomFive);
        Set<SampleData> treeSet = new TreeSet<>(randomFive); // Sortiert nach Namen
        Map<Integer, SampleData> hashMap = new HashMap<>();
        for (SampleData sample : randomFive) {
            hashMap.put(sample.getId(), sample); // ID als Schlüssel
        }

        // 4. Iterieren und Namen ausgeben
        System.out.println("ArrayList:");
        for (SampleData sample : arrayList) {
            System.out.println(sample.getName());
        }

        System.out.println("\nTreeSet:");
        for (SampleData sample : treeSet) {
            System.out.println(sample.getName());
        }

        System.out.println("\nHashMap:");
        for (SampleData sample : hashMap.values()) {
            System.out.println(sample.getName());
        }
    }
}