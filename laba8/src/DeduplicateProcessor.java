import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DeduplicateProcessor {
    @DataProcessor
    public static void deduplicateData(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);

            char[] chars = s.toCharArray();
            Set<Character> charSet = new LinkedHashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }

            StringBuilder sb = new StringBuilder();
            for (Character character : charSet) {
                sb.append(character);
            }
            data.set(i, sb.toString());
        }
    }
}