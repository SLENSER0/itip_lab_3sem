import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "src\\text.txt";

        File file = new File(filePath);

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (word.matches("[a-zA-Zа-яА-Я]+")) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        scanner.close();


        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int topCount = Math.min(10, list.size());

        for (int i = 0; i < topCount; i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
    }
}
