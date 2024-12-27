package Debugging;

	public class Debugging {
		
		 public static void main(String[] args) {
		 int[] numsIn;
		 int[] numsOut;
		 
		 // Convert command-line args to integer array
		 numsIn = new int[args.length];
		 for (int i = 0; i < args.length; i++) {
		 numsIn[i] = Integer.parseInt(args[i]);
		 }
		 
		 // Create the second array
		 int lengthNumsOut = (numsIn.length +1) / 2; // error
		 numsOut = new int[lengthNumsOut];
		 
		 // Process the first array into the second
		 for (int i = 0; i < lengthNumsOut; i++) {
		 numsOut[i] = numsIn[i] + numsIn[numsIn.length - i - 1]; // error
		 }
		 
		 // Print the result
		 for (int i = 0; i < lengthNumsOut; i++) {
			System.out.println(numsOut[i]);	 
				 }
				// error
	}
}