import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class EchoServerTest {
    private static final int PORT = 1234;
    @Test
    public void testReceivedDataIsEchoedBackInSentData() {
        BufferedReader input = new BufferedReader(
                new StringReader("bye"));
        PrintWriter output = new PrintWriter(new StringWriter(), true);
        ServerSocketWrapperSpy socketWrapper =
                new ServerSocketWrapperSpy(input, output);
        EchoServer echoServer = new EchoServer(socketWrapper);
        echoServer.start(PORT);
        assertTrue(socketWrapper.wasCreateAndListenCalled());
        assertEquals("echo", socketWrapper.getSentData());
        assertTrue(socketWrapper.wasCloseCalled());
    }
}