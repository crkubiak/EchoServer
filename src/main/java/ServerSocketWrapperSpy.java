import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerSocketWrapperSpy implements SocketWrapper {
    private BufferedReader input;
    private PrintWriter output;
    private boolean createAndListenCalled = false;
    private String sentData;
    private boolean closeCalled = false;

    public ServerSocketWrapperSpy(BufferedReader input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    public void createAndListen(int port) {
        createAndListenCalled = true;
    }

    public String receive() {
        try {
            return input.readLine();
        } catch (IOException e) {
            System.err.println("Error reading mock socket input");
        }
        return "";
    }

    public void send(String data) {
        this.sentData = data;
    }

    public void close() {
        closeCalled = true;
    }

    public boolean wasCreateAndListenCalled() {
        return createAndListenCalled;
    }

    public String getSentData() {
        return sentData;
    }

    public boolean wasCloseCalled() {
        return closeCalled;
    }
}
