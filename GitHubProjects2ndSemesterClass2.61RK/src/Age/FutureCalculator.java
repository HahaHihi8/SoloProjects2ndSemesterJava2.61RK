package Age;

import java.time.LocalDate;
import java.time.Period;

public class FutureCalculator {
    public static void main(String[] args) {
        // Heutiges Datum
        LocalDate today = LocalDate.now();

        // Periode von 42 Tagen erstellen
        Period period = Period.ofDays(42);
        
        //   Datum in 42 Tagen berechnen
        //   LocalDate futureDate = today.plusDays(42);

        // Datum in 42 Tagen berechnen
        LocalDate futureDate = today.plus(period);

        System.out.println("Heutiges Datum: " + today);
        System.out.println("Datum in 42 Tagen: " + futureDate);
    }
}