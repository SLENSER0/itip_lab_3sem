import java.io.FileWriter;
import java.io.IOException;

public class Division
{
    public static void main(String[] args) {
        try {
            divideNumbers(10, 2);
            divideNumbers(8, 0);
        } catch (CustomDivisionException e) {
            System.out.println("Ошибка деления на ноль: " + e.getMessage());
            logException(e);
        }

    }
    private static void divideNumbers(int numerator, int denominator) throws CustomDivisionException {
        if (denominator == 0) {
            throw new CustomDivisionException("Деление на ноль недопустимо");
        }
        int result = numerator / denominator;
        System.out.println("Результат деления: " + result);
    }
    private static void logException(Exception e)
    {
        try (FileWriter writer = new FileWriter("src\\log.txt", true))
        {
            writer.write("Exception: " + e.getMessage() + "\n");
        } catch (IOException ioException) {
            System.out.println("Ошибка записи в лог файл: " + ioException.getMessage());
        }
    }
}