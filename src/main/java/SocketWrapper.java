public interface SocketWrapper {
    void createAndListen(int port);
    String receive();
    void send(String data);
    void close();
}
