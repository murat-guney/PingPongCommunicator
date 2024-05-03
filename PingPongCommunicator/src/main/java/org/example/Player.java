package org.example;

/**
 * Represents a player in a two-player communication game within the same process.
 * This class manages the sending of messages, appending a count to each message to ensure uniqueness.
 *
 * Responsibilities:
 * - Send messages: Appends a count to outgoing messages for traceability.
 * - Handle received messages: Processes incoming messages by appending a count before responding.
 */
public class Player {
    private String name;
    private int messageCount;

    public Player(String name, int startCount) {
        this.name = name;
        this.messageCount = startCount;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Sends a message by appending the message count to a received message, then increments the count.
     * @param receivedMessage The message received from another player.
     * @return The modified message with the appended count.
     */
    public String sendMessage(String receivedMessage) {
        String messageToSend = receivedMessage + messageCount;
        messageCount++;  // Increment the count after modifying the message.
        return messageToSend;
    }
}