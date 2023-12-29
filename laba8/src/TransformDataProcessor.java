import java.util.List;

public class TransformDataProcessor {
    @DataProcessor
    public static void transformToUpper(List<String> data) {

        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).toUpperCase());
        }
    }
}
