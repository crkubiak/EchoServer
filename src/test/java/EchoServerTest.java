import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class EchoServerTest {
    private static final int PORT = 1234;

    @Test
    public void testReceivedDataIsEchoedBackInSentData() {
        BufferedReader input = new BufferedReader(
                new StringReader("echo"));
        PrintWriter output = new PrintWriter(new StringWriter(), true);
        ServerSocketWrapperSpy socketWrapper =
                new ServerSocketWrapperSpy(input, output);
        EchoServer echoServer = new EchoServer(socketWrapper);
        echoServer.start(PORT);
        assertTrue(socketWrapper.wasCreateAndListenCalled());
        assertEquals("echo", socketWrapper.getSentData());
        assertTrue(socketWrapper.wasCloseCalled());
    }

    @Test (expected = ServerConnectionException.class)
    public void testErrorStartingServer() {
        ServerSocketWrapper serverSocketWrapper = new ErrorConnectingServerSocketWrapperStub();
        EchoServer server = new EchoServer(serverSocketWrapper);

        server.start(PORT);
    }

    @Test (expected = ServerConnectionException.class)
    public void testErrorReceivingInput() {
        ServerSocketWrapper serverSocketWrapper = new ErrorReceivingMessageServerSocketWrapperStub();
        EchoServer server = new EchoServer(serverSocketWrapper);

        server.start(PORT);
    }

    @Test (expected = ServerConnectionException.class)
    public void testErrorDisconnectingServer() {
        ServerSocketWrapper serverSocketWrapper = new ErrorDisconnectingEchoClientConnectionStub();
        EchoServer server = new EchoServer(serverSocketWrapper);

        server.start(PORT);
    }
}