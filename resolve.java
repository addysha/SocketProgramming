import java.net.InetAddress;

/**
 * The resolve class resolves a list of domain names to their corresponding IPv4 addresses.
 * It takes domain names as command-line arguments and displays their IPv4 addresses if available.
 */
public class resolve {

    /**
     * The main method is the entry point of the program.
     * It checks for command-line arguments, resolves the domain names,
     * and displays the corresponding IPv4 addresses.
     *
     * @param args The command-line arguments containing domain names to resolve.
     */
    public static void main(String[] args) {
        // Check if any command-line arguments are provided
        if (args.length == 0) {
            System.out.println("Usage: resolve <name1> <name2> ... <nameN>");
            return;
        }

        // Loop through each domain name provided as a command-line argument
        for (String hostname : args) {
            try {
                // Try to resolve the domain name to its IP address
                InetAddress address = InetAddress.getByName(hostname);
                System.out.println(hostname + " : " + address.getHostAddress());
            } catch (Exception e) {
                // If the domain name cannot be resolved, display "unknown host"
                System.out.println(hostname + " : unknown host");
            }
        }
    }
}

