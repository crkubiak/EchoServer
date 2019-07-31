import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ErrorDisconnectingEchoClientConnectionStub extends ServerSocketWrapper {
    public void createAndListen(int port) {
     // intentionally empty
    }

    public String receive() {
        try {
            return new BufferedReader(Reader.nullReader()).readLine();
        } catch (IOException e) {
            throw new RuntimeException("[-]Error reading null reader.");
        }
    }

    public void send(String message) {
        // intentionally empty
    }

    public void close() {
        throw new ServerConnectionException();
    }
}
