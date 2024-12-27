package ChatBot;

public class FriendlyPersonality implements Personality {

    public String getGreeting() {
        return "Hello! How can I help you today?";
    }

    public String answerQuestion() {
        return "That's a great question! Let me think...";
    }

    public String getGoodbye() {
        return "Goodbye! Have a great day!";
    }

    public String getOther() {
        return "I'm here to help. Ask me anything!";
    }
}
