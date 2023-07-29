import java.net.InetAddress;

/**
 * The reverse class performs reverse DNS lookups to obtain the DNS names corresponding to a list of IP addresses.
 * It takes IP addresses as command-line arguments and displays their corresponding DNS names if available.
 */
public class reverse {

    /**
     * The main method is the entry point of the program.
     * It checks for command-line arguments, performs reverse DNS lookups,
     * and displays the corresponding DNS names or "no name" if not available.
     *
     * @param args The command-line arguments containing IP addresses to resolve.
     */
    public static void main(String[] args) {
        // Check if any command-line arguments are provided
        if (args.length == 0) {
            System.out.println("Usage: reverse <ip1> <ip2> ... <ipN>");
            return;
        }

        // Loop through each IP address provided as a command-line argument
        for (String ipAddress : args) {
            try {
                // Try to perform reverse DNS lookup to get the host name
                InetAddress address = InetAddress.getByName(ipAddress);
                String hostName = address.getHostName();

                // If the host name is the same as the IP address, it means no DNS name is available
                if (hostName.equals(ipAddress)) {
                    System.out.println(ipAddress + " : no name");
                } else {
                    System.out.println(ipAddress + " : " + hostName);
                }
            } catch (Exception e) {
                // If the reverse lookup fails, display "no name"
                System.out.println(ipAddress + " : no name");
            }
        }
    }
}
