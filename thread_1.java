public class Thread_1 extends Thread {
    private final int threadnumber;
    private final int[] randomMassive;
    public Thread_1(int threadnumber, int[] randomMassive) {
        this.threadnumber = threadnumber;
        this.randomMassive = randomMassive;
    }
    @Override
    public void run() {
        Integer firstEven = null;
        int totalSum = 0;
        System.out.println("Hello World от потока №" + threadnumber);
        for (int i = randomMassive.length - 1; i >= 0; i--) {
            int value = randomMassive[i];
            if (value % 2 == 0) {
                continue;
            }
            if (firstEven == null) {
                firstEven = value;
                continue;
            }
            int sum = firstEven * value;
            System.out.println("Thread1:" + sum);
            totalSum += sum;
            firstEven = null;
        }
        System.out.println("Total sum: " + totalSum);
    }
}
