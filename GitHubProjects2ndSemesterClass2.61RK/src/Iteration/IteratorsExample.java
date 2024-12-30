package Iteration;

import java.util.*;

public class IteratorsExample {
    public static void main(String[] args) {
    	
        // 1. Erstellen von fünf Objekten der Klasse SampleData
        SampleData[] data = {
            new SampleData(1, "Jade Ace Rogers"),
            new SampleData(2, "Madge Jan Rivera"),
            new SampleData(3, "Faye Gia Price"),
            new SampleData(4, "Dee Gwen Harris"),
            new SampleData(5, "Coe Kim Flores")
        };

        // 2. Hinzufügen der Objekte zu verschiedenen Datenstrukturen
        List<SampleData> arrayList = new ArrayList<>(Arrays.asList(data));
        Set<SampleData> treeSet = new TreeSet<>(arrayList); // Sortiert nach Namen
        Map<Integer, SampleData> hashMap = new HashMap<>();
        for (SampleData sample : data) {
            hashMap.put(sample.getId(), sample); // ID als Schlüssel
        }

        // 3. Iterieren und Namen ausgeben
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
