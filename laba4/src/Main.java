public class Main {
    public static void main(String[] args) {
        String arr[] = {"1","2","3", "f"};
        int sum = 0;
        int n = arr.length;
        double mean;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            mean = (double) sum / n;
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за пределы массива");
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка: Элемент массива не является числом");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}