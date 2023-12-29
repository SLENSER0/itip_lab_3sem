import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearcher {
    public static void main(String[] args) {
        String text = "gfd fgfgz bsda hgdf Bbsfsd";
        text = text.toLowerCase();
        String targetLetter = "gf";

        Pattern pattern = Pattern.compile("\\b\\w*" + targetLetter + "\\w*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
