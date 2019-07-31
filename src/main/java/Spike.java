

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Spike {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8899);
        } catch(IOException e) {
            System.out.println("[-]Can't listen on port 8899");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("[+]Listening for connection...");
        try {
            clientSocket = serverSocket.accept();
        } catch(IOException e) {
            System.out.println("[-]Accept failed");
            System.exit(1);
        }

        System.out.println("[+]Connection successful");
        System.out.println("[+]Listening for input");

        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = input.readLine()) != null) {
            System.out.println("Server: " + inputLine);
            output.println(inputLine);

            if(inputLine.equals("bye")) {
                break;
            }
        }
        output.close();
        input.close();
        clientSocket.close();
        serverSocket.close();
    }
}
