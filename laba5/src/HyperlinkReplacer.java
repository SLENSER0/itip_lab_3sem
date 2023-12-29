public class HyperlinkReplacer {
    public static void main(String[] args) {
        String text = "example.com and examfple.com.uk";

        String regex = "([a-zA-Z]+[.][a-zA-Z]+([.][a-zA-Z]+)?)";

        String result = text.replaceAll(regex,"https://$0");
        System.out.println(result);
    }
}
