package org.example;

/**
 * Manages communication between two players within the same Java process.
 * This class starts the communication with an initial message and continues
 * exchanging messages until a set number of exchanges is reached.
 *
 * Responsibilities:
 * - Initiate and manage communication between two players.
 * - Control message exchange to meet a predefined stop condition.
 * - Log the message exchanges for verification.
 */
public class LocalCommunication {

    private Player initiator;
    private Player receiver;

    private LocalCommunication(Player initiator, Player receiver) {
        this.initiator = initiator;
        this.receiver = receiver;
    }

    /**
     * Starts the game by creating player instances and initiating the play method.
     */
    public static void startGame() {
        Player initiator = new Player("Initiator", 1);
        Player receiver = new Player("Receiver", 0);
        LocalCommunication game = new LocalCommunication(initiator, receiver);
        game.play();
    }

    /**
     * Manages the communication process by exchanging messages between the initiator
     * and receiver. It controls the loop of sending and receiving messages, ensuring
     * the game ends after a specified number of exchanges.
     */
    private void play() {
        String message = "hello";  // Initial message from initiator

        // Start with the initiator sending the first message as part of the loop
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                System.out.println(initiator.getName() + ": " + message);  // Print the first message
            }

            // Receiver adds its count to the message and sends it back
            message = receiver.sendMessage(message);
            System.out.println(receiver.getName() + ": " + message);

            // Initiator adds its count to the message and sends it back
            message = initiator.sendMessage(message);
            if (i < 9) { // Check to avoid printing after the last send
                System.out.println(initiator.getName() + ": " + message);
            }
        }
    }
}