package org.example;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * The PlayerClient class represents a player in the communication game.
 * This class acts as a client that sends messages to and receives messages from the PlayerServer.
 */
public class PlayerClient {

    public static void main(String[] args) {
        startClient();
    }

    public static void startClient() {
        String host = "localhost";  // server ip
        int port = 8001;            // port number
        try (Socket socket = new Socket(host, port);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

            // Sends a message to server
            String toSend = "Schönen Tag from client";
            output.writeUTF(toSend);
            System.out.println("Sent to server: " + toSend);

            // read the response from the server
            String response = input.readUTF();
            System.out.println("Received from server: " + response);

        } catch (IOException e) {
            System.out.println("IO Exception in client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}