package Age;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Format für das Datum
        
        // Geburtsdatum vom Benutzer einlesen
        System.out.print("Bitte geben Sie Ihr Geburtsdatum ein (im Format yyyy-MM-dd): ");
        String input = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(input, formatter);

        // Heutiges Datum
        LocalDate today = LocalDate.now();

        // Alter in Jahren, Monaten und Tagen berechnen
        Period age = Period.between(birthDate, today);
        System.out.println("\nAlter:");
        System.out.println("Jahre: " + age.getYears());
        System.out.println("Monate: " + age.getMonths());
        System.out.println("Tage: " + age.getDays());

        // Alter in Tagen berechnen
        long daysAlive = ChronoUnit.DAYS.between(birthDate, today);
        System.out.println("Alter in Tagen: " + daysAlive);

        scanner.close(); // Scanner schließen
    }
}
