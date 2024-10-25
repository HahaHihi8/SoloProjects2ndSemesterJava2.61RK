package Calculator;

// Model class for the calculator => this class will do the actual calculations

public class CalculatorModel {
	
	protected String calculate(String in) {
        // Initialize error and result
        boolean error = false;
        String result;

        // Split the input string by '+' and '-' into an array of strings
        String[] strValues = in.split("[+-]");
        // Create an array to store the operators
        char[] operators = new char[strValues.length - 1];
        int operatorIndex = 0;

        // Extract operators from the input string
        for (char c : in.toCharArray()) {
            if (c == '+' || c == '-') {
                operators[operatorIndex++] = c;
            }
        }

        // Convert Strings to ints - catch any errors
        int[] intValues = new int[strValues.length];
        try {
            for (int i = 0; i < strValues.length; i++) {
                intValues[i] = Integer.parseInt(strValues[i]);
            }
        } catch (NumberFormatException e) {
            error = true;
        }

        // If error, set result
        // If no error, perform operations and set result
        if (error) {
            result = "Error";
        } else {
            int sum = intValues[0];
            for (int i = 1; i < intValues.length; i++) {
                if (operators[i - 1] == '+') {
                    sum += intValues[i];
                } else if (operators[i - 1] == '-') {
                    sum -= intValues[i];
                }
            }
            result = Integer.toString(sum);
        }

        return result;
    }
}