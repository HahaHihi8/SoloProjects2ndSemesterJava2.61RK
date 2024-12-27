package Box;

import java.util.ArrayList;
import java.util.Collections;

public class BoxTest {
	public static void main(String[] args) {
        // Testboxen erstellen
        Box box1 = new Box(2, 3, 4); // Volumen: 24
        Box box2 = new Box(2, 3, 4); // Volumen: 24
        Box box3 = new Box(1, 2, 3); // Volumen: 6
        Box box4 = new Box(4, 5, 6); // Volumen: 120

        // equals-Methode testen
        System.out.println("box1 equals box2: " + box1.equals(box2)); // true
        System.out.println("box1 equals box3: " + box1.equals(box3)); // false

        // compareTo-Methode testen
        System.out.println("box1 compared to box3: " + box1.compareTo(box3)); // > 0
        System.out.println("box1 compared to box2: " + box1.compareTo(box2)); // 0
        System.out.println("box1 compared to box4: " + box1.compareTo(box4)); // < 0

        // Boxen sortieren
        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);

        System.out.println("Before sorting:");
        boxes.forEach(System.out::println);

        Collections.sort(boxes);

        System.out.println("\nAfter sorting:");
        boxes.forEach(System.out::println);
    }
}