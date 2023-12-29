import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Warehouse {
    private final Lock lock = new ReentrantLock();
    private final Condition enoughWeightCondition = lock.newCondition();

    private List<Integer> products = new ArrayList<>();
    private int currentWeight = 0;

    public void addProduct(int weight) throws InterruptedException {
        lock.lock();
        try {
            while (currentWeight + weight > 150) {
                enoughWeightCondition.await();
            }

            products.add(weight);
            currentWeight += weight;
            System.out.println("Added product with weight " + weight + ". Current weight: " + currentWeight);

            if (currentWeight + weight >= 150) {
                System.out.println("Sending products to another warehouse.");
                products.clear();
                currentWeight = 0;
                enoughWeightCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}