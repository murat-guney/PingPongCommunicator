package org.example;

/**
 * The Main class serves as the entry point of the application.
 * It initializes the game based on the provided command-line arguments.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && "local".equals(args[0])) {
            LocalCommunication.startGame();
        } else {
            printUsage();
        }
    }

    /**
     * Prints the usage information for the application.
     * This method is invoked when incorrect or no command-line arguments are provided.
     */
    private static void printUsage() {
        System.out.println("Invalid arguments. Usage:");
        System.out.println("  java -jar PlayerCommunication.jar local");
    }
}