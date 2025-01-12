package Jabberwocky;

public class JabberwockyModel {

    private String data;

    public JabberwockyModel() {
        this.data = "Jabberwocky Data";
    }

    // Getter and Setter for data
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String executeAlgorithm(String input) {
        if (input == null || input.isEmpty()) {
        	return "No input provided";
        }
        return input.toUpperCase();
    }
}