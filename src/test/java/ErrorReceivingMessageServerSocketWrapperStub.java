public class ErrorReceivingMessageServerSocketWrapperStub extends ServerSocketWrapper {
    public void createAndListen(int port) {
        // intentionally empty
    }

    public String receive() {
        throw new ServerConnectionException();
    }
}
