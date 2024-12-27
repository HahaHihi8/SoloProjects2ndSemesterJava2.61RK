package ChatBot;

public class InsultingPersonality implements Personality {

    public String getGreeting() {
        return "What do you want?";
    }

    public String answerQuestion() {
        return "That's a dumb question.";
    }

    public String getGoodbye() {
        return "Finally, you're leaving.";
    }

    public String getOther() {
        return "Why are you wasting my time?";
    }
}
