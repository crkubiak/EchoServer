public class EchoServer {
    private SocketWrapper socketWrapper;

    public EchoServer(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
    }

    void start(int port) {
        try {
            socketWrapper.createAndListen(port);
            run();
        } catch (ServerConnectionException e) {
            throw new ServerConnectionException();
        }
    }

    private void run() {
        String message;
        try{
            while((message = socketWrapper.receive()) != null) {
                if(message.equals("bye")) {
                    socketWrapper.send(message);
                    break;
                } else {
                    socketWrapper.send(message);
                }
            }
            stop();
        } catch (ServerConnectionException e) {
            throw new ServerConnectionException();
        }

    }

    private void stop() {
        try {
            socketWrapper.close();
        } catch (ServerConnectionException e) {
            throw new ServerConnectionException();
        }
    }

    public static void main(String[] args) {
        SocketWrapper socketWrapper = new ServerSocketWrapper();
        EchoServer echoServer = new EchoServer(socketWrapper);
        echoServer.start(Integer.parseInt(args[0]));
    }
}
