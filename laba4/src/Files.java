import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
    public static void main(String[] args) {
        String path1 = "src\\a.txt";
        String path2 = "src\\b.txt";
        try {
            copy(path1,path2);
            System.out.println("Файл скопирован");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void copy(String path1, String path2) throws IOException {
        try(FileReader reader = new FileReader(path1);
            FileWriter  writer = new FileWriter(path2)) {
            int character;
            writer.close();

            while ((character = reader.read()) != -1) {
                writer.write(character);
            }

        }
    }
}