package org.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * The PlayerServer class handles incoming connections and messages from PlayerClient instances.
 * It serves as a server listening on a specific port for messages and responds to them.
 */
public class PlayerServer {

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        int port = 8001;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                    String message = input.readUTF();
                    System.out.println("Received from client: " + message);
                    // respond to the received message.
                    output.writeUTF("Echo from server: " + message);
                } catch (IOException e) {
                    System.out.println("IO Exception in server connection loop: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Server could not listen on port " + port + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}