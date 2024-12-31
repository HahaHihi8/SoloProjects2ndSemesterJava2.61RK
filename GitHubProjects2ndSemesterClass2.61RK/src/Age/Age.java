package Age;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Age {
  
	public static void main(String[] args) {
		LocalDate birthDate = LocalDate.of(1994, 8, 8);
		LocalDate currentDate = LocalDate.now();
		
		Period age = Period.between(birthDate, currentDate);
		System.out.println("Alter:");
		System.out.println(age.getYears() + " Jahre");
		System.out.println(age.getMonths() + " Monate");
		System.out.println(age.getDays() + " Tage");

		Duration age1 = Duration.between(birthDate.atStartOfDay(), currentDate.atStartOfDay());
		System.out.println("Alter in Tagen: " + age1.toDays());
		System.out.println("Alter in Stunden: " + age1.toHours());
		System.out.println("Alter in Minuten: " + age1.toMinutes());
		System.out.println("Alter in Sekunden: " + age1.getSeconds());
		
		
		long daysAlive = ChronoUnit.DAYS.between(birthDate, currentDate);
		System.out.println("Tage gelebt: " + daysAlive);
		
		long monthsAlive = ChronoUnit.MONTHS.between(birthDate, currentDate);
		System.out.println("Alive in Monaten: " + monthsAlive);		
	}
}