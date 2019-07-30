public class ErrorConnectingServerSocketWrapperStub extends ServerSocketWrapper {
    public void createAndListen(int port) {
        throw new ServerConnectionException();
    }
}
