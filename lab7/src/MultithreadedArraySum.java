public class MultithreadedArraySum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};

        ArraySumThread thread1 = new ArraySumThread(array, 0, array.length / 2);
        ArraySumThread thread2 = new ArraySumThread(array, array.length / 2, array.length);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

            int totalSum = thread1.getSum() + thread2.getSum();

            System.out.println("sum: " + totalSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ArraySumThread extends Thread {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int sum;

    public ArraySumThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
