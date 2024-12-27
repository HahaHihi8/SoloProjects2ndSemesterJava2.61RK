package ExceptionDemos;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice = -1;
		while (choice != 0) {
			System.out.println("What do you want to do?");
			System.out.println("0 - Exit this program");
			System.out.println("1 - Use an invalid array index");
			System.out.println("2 - Divide-by-zero with int-values");
			System.out.println("3 - Divide-by-zero with float-values");
			System.out.println("4 - Use a null pointer");
			System.out.println("5 - Something else you think should be an exception");
			choice = in.nextInt();
			try {
				System.out.println("Entering 'try'");
				switch (choice) {
				case 0: // Do nothing - quitting
					break;
				case 1: // Use an invalid array index
					int[] array = new int[3];
					System.out.println(array[5]);
					break;
				case 2: // Divide by zero using int-values
					int one = 1;
					int zero = 0;
					System.out.println(one / zero);
					break;
				case 3: // Divide by zero using float-values
					float oneF = 19.0f;
					float zeroF = 0.0f;
					System.out.println(oneF / zeroF);
					break;
				case 4: // Try to use a null pointer
					String s = null;
					System.out.println(s.length());
					break;
				case 5: // Something else
					throw new IllegalArgumentException("This is a custom exception");
				default:
					System.out.println("Invalid choice, no exception");
				}
			} catch (Exception e) {
				System.out.println("Exception caught: " + e.getClass());
			} finally {
				System.out.println("Executing 'finally'");
			}
		}
		in.close();
	}
}