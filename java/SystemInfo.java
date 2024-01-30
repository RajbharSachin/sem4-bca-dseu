import java.net.InetAddress;

public class SystemInfo {
    public static void main(String[] args) {
        try {
            // Get hostname
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println("Hostname: " + hostname);

            // Get IP address
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println("IP Address: " + ipAddress);

            // Get username
            String username = System.getProperty("user.name");
            System.out.println("Username: " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
