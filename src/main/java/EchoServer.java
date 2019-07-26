public class EchoServer {
    private SocketWrapper socketWrapper;

    public EchoServer(SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
    }

    void start(int port) {
        socketWrapper.createAndListen(port);
        run();
    }

    private void run() {
        String message = socketWrapper.receive();
        while(message != null) {
            if(message == "bye") {
                socketWrapper.send(message);
                stop();
            } else {
                socketWrapper.send(message);
                run();
            }
        }
    }

    private void stop() {
        socketWrapper.close();
    }

    public static void main(String[] args) {
        SocketWrapper socketWrapper = new ServerSocketWrapper();
        EchoServer echoServer = new EchoServer(socketWrapper);
        echoServer.start(Integer.parseInt(args[0]));
    }
}
