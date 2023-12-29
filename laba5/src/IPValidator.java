public class IPValidator {
    public static void main(String[] args) {
        String str = "192.168.0.1";

        if (str.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }
    }
}
