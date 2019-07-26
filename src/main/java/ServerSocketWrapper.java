import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerSocketWrapper implements SocketWrapper {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public void createAndListen(int port) {
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Error");
        }
    }

    public String receive() {
        try {
            return input.readLine();
        } catch (IOException e) {
            System.err.println("Error");
            return "Error";
        }
    }

    public void send(String data) {
        output.println(data);
    }

    public void close() {
        try {
            output.close();
            input.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
