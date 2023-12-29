
public class WarehouseSimulation {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Thread loader1 = new Thread(new Loader(warehouse));
        Thread loader2 = new Thread(new Loader(warehouse));
        Thread loader3 = new Thread(new Loader(warehouse));

        loader1.start();
        loader2.start();
        loader3.start();
    }

}