import java.util.Random;

class Loader implements Runnable {
    private final Warehouse warehouse;
    private final Random random = new Random();

    public Loader(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            int randomWeight = random.nextInt(50) + 1;
            try {
                warehouse.addProduct(randomWeight);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}