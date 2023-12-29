import java.util.LinkedHashMap;
import java.util.Map;

public class Sales {
    private Map<String, Integer> salesData = new LinkedHashMap<>();

    public void addSale(String product, int quantity) {
        salesData.put(product, salesData.getOrDefault(product, 0) + quantity);
    }

    public void displaySales() {
        System.out.println("List of sold items:");
        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public int calculateTotalSales() {
        int totalSales = 0;
        for (int quantity : salesData.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    public String findMostPopularProduct() {
        int maxSales = 0;
        String mostPopularProduct = null;
        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopularProduct = entry.getKey();
            }
        }
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        Sales salesTracker = new Sales();

        salesTracker.addSale("Item1", 10);
        salesTracker.addSale("Item2", 5);
        salesTracker.addSale("Item1", 7);
        salesTracker.addSale("Item3", 12);

        salesTracker.displaySales();

        System.out.println("total sales: " + salesTracker.calculateTotalSales());

        System.out.println("most popular item: " + salesTracker.findMostPopularProduct());
    }
}
