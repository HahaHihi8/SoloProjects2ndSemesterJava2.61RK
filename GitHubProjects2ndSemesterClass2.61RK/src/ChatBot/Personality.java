package ChatBot;

public interface Personality {
    String getGreeting();
    String answerQuestion();
    String getGoodbye();
    String getOther(); // Generelle Antwort
}