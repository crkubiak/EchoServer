import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class EchoClient {

    public static void main(String[] args) throws Exception {

        Socket socket = null;
        PrintWriter output = null;
        BufferedReader input = null;

        try {
            socket = new Socket("127.0.0.1", Integer.parseInt(args[0]));
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("[-]Unknown Host.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("[-]Can't connect to the server.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;

        while((userInput = stdIn.readLine()) != null) {
            output.println(userInput);
            System.out.println("Echo " + input.readLine());
            if (userInput.equals("Bye")){
                break;
            }
        }
        output.close();
        input.close();
        stdIn.close();
        socket.close();
    }
}
