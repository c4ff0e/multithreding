
public class Thread_3 extends Thread {
    private final int threadnumber;
    private final int[] randomMassive;
    public Thread_3(int threadnumber, int[] randomMassive) {
        this.threadnumber = threadnumber;
        this.randomMassive = randomMassive;
    }
    @Override
    public void run() {
        Integer firstEven = null;
        int totalSum = 0;
        System.out.println("Hello World от потока №" + threadnumber + " " + randomMassive[1]);
        for (int i = randomMassive.length - 1; i >= 0; i--) {
            int value = randomMassive[i];
            if (value % 2 != 0) {
                continue;
            }

            if (firstEven == null) {
                firstEven = value;
                continue;
            }
            int sum = firstEven * value;
            System.out.println("Thread3:" + sum);
            totalSum += sum;
            firstEven = null;
        }
        System.out.println("Thread3: Cумма произведения четных чисел: " + totalSum);
    }
}
