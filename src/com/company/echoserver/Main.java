package com.company.echoserver;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {
        // creates server on port 5000
        try (ServerSocket socket = new ServerSocket(5000)) {
            // continuously listen out for clients - (.accept() blocks until it receives a connection attempt)
            while (true) {
                new Echoer(socket.accept()).start();
            }

        } catch (IOException e) {
            System.out.println("Server exception encountered " + e.getMessage());
            e.printStackTrace();
        }
    }
}
