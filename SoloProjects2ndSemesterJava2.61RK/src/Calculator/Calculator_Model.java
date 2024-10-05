package Calculator;

public class Calculator_Model {
	
private double result;
private String operator;
	    
public CalculatorModel() {
result = 0;
operator = "";
}
	    
// Methoden zur Durchführung von Berechnungen
public void calculate(double input, String operator) {
	switch (this.operator) {
	 case "+":
	                result += input;
	                break;
	            case "-":
	                result -= input;
	                break;
	            case "*":
	                result *= input;
	                break;
	            case "/":
	                result /= input;
	                break;
	            default:
	                result = input;
	                break;
	        }
	        this.operator = operator;
	    }

	    public double getResult() {
	        return result;
	    }

	    public void clear() {
	        result = 0;
	        operator = "";
	    }
}
