package com.company.echoserver;

import jdk.net.Sockets;

import java.io.*;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    // socket.accept() argument is passed by the caller -  it returns a socket in-turn
    public Echoer (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connection established.");
            while (true) {
                String echoString = input.readLine();   // response from client
                if (echoString.toLowerCase().equals("exit")) {
                    break;
                }
                output.println("Response from server : " + echoString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
