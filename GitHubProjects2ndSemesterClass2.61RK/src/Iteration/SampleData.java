package Iteration;

import java.util.Random;

public class SampleData implements Comparable<SampleData> {
    private int id;
    private String name;

    // Konstruktor
    public SampleData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter-Methoden
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Für TreeSet: Vergleicht nach Namen
    @Override
    public int compareTo(SampleData other) {
        return this.name.compareTo(other.name);
    }

    // Für HashMap: Vergleicht nach ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SampleData that = (SampleData) obj;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

 // Methode zur Generierung zufälliger Namen
    public static String generateRandomName() {
        String[] firstNames = {"Jade", "Madge", "Faye", "Dee", "Coe", "Zoe", "Luke", "Dan", "Val", "Bern"};
        String[] lastNames = {"Ace", "Beck", "Jan", "Reid", "Kim", "Gwen", "Joel", "Morris", "Flores", "Rivera"};

        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];

        return firstName + " " + lastName;
    }
}