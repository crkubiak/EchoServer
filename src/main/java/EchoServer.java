import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSock = null;
        try{
            serverSock = new ServerSocket(8899);
        } catch (IOException e) {
            System.out.println("[-]Can't listen on port number 8899.");
            System.exit(1);
        }

        Socket clientSock = null;
        System.out.println("[+]Listening for connect...");
        try{
            clientSock = serverSock.accept();
        } catch (IOException e) {
            System.out.println("[-]Accept failed.");
            System.exit(1);
        }

        System.out.println("[+]Connection successfull.");
        System.out.println("[+]Listening for input.");

        PrintWriter output = new PrintWriter(clientSock.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));

        String inputLine;

        while((inputLine = input.readLine()) != null) {
            System.out.println("Server: " + inputLine);
            output.println(inputLine);

            if(inputLine.equals("Bye")) {
                break;
            }
        }

        output.close();
        input.close();
        clientSock.close();
        serverSock.close();
    }
}
