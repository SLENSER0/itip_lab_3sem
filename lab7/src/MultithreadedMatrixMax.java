public class MultithreadedMatrixMax {

    public static void main(String[] args) {

        int[][] matrix = new int[][]
                {{1,2,3},
                {3,99,5},
                {6,7,8,5656}};

        int rows = matrix.length;


        MaxFinderThread[] threads = new MaxFinderThread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new MaxFinderThread(matrix[i]);
            threads[i].start();
        }

        try {
            for (MaxFinderThread thread : threads) {
                thread.join();
            }

            int maxElement = Integer.MIN_VALUE;
            for (MaxFinderThread thread : threads) {
                int threadMax = thread.getMax();
                if (threadMax > maxElement) {
                    maxElement = threadMax;
                }
            }

            System.out.println("max: " + maxElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MaxFinderThread extends Thread {
    private int[] row;
    private int max;

    public MaxFinderThread(int[] row) {
        this.row = row;
        this.max = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        for (int value : row) {
            if (value > max) {
                max = value;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
