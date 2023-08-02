import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * The SimpleClient class is a simple client program that connects to the server,
 * prints out whatever the server sends back, and then exits.
 * @author Aditya Sharma (ID: 1616591)
 */
public class SimpleClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SimpleClient <server> <port>");
            return;
        }

        String server = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            // Connect to the server
            Socket clientSocket = new Socket(server, port);

            // Read the server's response
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
