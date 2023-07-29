import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The SimpleServer class is a simple network server that greets each client that connects and then disconnects them.
 * It listens on an available port and prints the chosen port number to the console.
 * When a client connects, it obtains the client's IP address, resolves it to its name, and greets the client.
 */
public class SimpleServer {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket bound to an available port
            ServerSocket serverSocket = new ServerSocket(12345);
            int port = serverSocket.getLocalPort();
            System.out.println("Listening on port " + port);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Obtain the client's IP address and resolve it to its name
                InetAddress clientAddress = clientSocket.getInetAddress();
                String clientHostName = clientAddress.getHostName();

                // Greet the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello, " + clientHostName + ".");
                out.println("Your IP address is " + clientAddress.getHostAddress());

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}