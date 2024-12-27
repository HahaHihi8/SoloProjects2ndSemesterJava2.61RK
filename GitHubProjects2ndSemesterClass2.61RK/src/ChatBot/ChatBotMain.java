package ChatBot;

import java.util.Scanner;

public class ChatBotMain {

	Scanner scanner = new Scanner(System.in);
	private Personality personality;

	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	public static void main(String[] args) {
        ChatBotMain chatBot = new ChatBotMain();
        chatBot.run();
    }

    public void run() {
        displayMenu();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Verarbeite Zeilenumbruch

        switch (choice) {
            case 1:
                setPersonality(new FriendlyPersonality());
                break;
            case 2:
                setPersonality(new InsultingPersonality());
                break;
            default:
                System.out.println("Invalid input. Defaulting to Friendly Personality.");
                setPersonality(new FriendlyPersonality());
        }

        interact();
    }

    public void displayMenu() {
        System.out.println("Welcome to the ChatBot!");
        System.out.println("Please choose a personality: ");
        System.out.println("1: Friendly");
        System.out.println("2: Insulting");
    }

    public void interact() {
        if (personality == null) {
            System.out.println("No personality selected. Exiting.");
            return;
        }

        System.out.println(personality.getGreeting());

        while (true) {
            System.out.println("Ask a question or type 'bye' to exit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(personality.getGoodbye());
                break;
            } else if (input.endsWith("?")) {
                System.out.println(personality.answerQuestion());
            } else {
                System.out.println(personality.getOther());
            }
        }
    }
}