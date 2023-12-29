public class Order {
    private String[] items;
    private String deliveryAddress;
    private int price;

    public Order(String[] items, String deliveryAddress, int price) {
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPrice() {
        return price;
    }

    public String[] getItems() {
        return items;
    }
}
