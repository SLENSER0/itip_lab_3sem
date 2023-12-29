public class Main {
    public static void main(String[] args) {
        HashTable<Integer, Order> orderTable = new HashTable<>();

        Order order1 = new Order(new String[]{"A","B","C"}, "street 1",4);
        Order order2 = new Order(new String[]{"F","B","K","L"}, "street 2",22);
        Order order3 = new Order(new String[]{"F","B","K","L"}, "street 2",22);
        Order order4 = new Order(new String[]{"F","B","K","L"}, "street 2",22);

        orderTable.put(1, order1);
        orderTable.put(3, order3);

        orderTable.put(3, order2);
        orderTable.put(43, order4);

        orderTable.printTable();

        orderTable.remove(3);

        System.out.println(orderTable.get(0));

    }
}