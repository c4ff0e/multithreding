public class Thread_2 extends Thread {
    private final int threadnumber;
    private final int[] randomMassive;
    public Thread_2(int threadnumber, int[] randomMassive) {
        this.threadnumber = threadnumber;
        this.randomMassive = randomMassive;
    }
    @Override
    public void run() {
        Integer firstEven = null;
        System.out.println("Hello World от потока №" + threadnumber);
        for (int i = 0; i < randomMassive.length; i++) {
            int value = randomMassive[i];
            if (value % 2 == 0) {
                continue;
            }
            if (firstEven == null) {
                firstEven = value;
                continue;
            }
            int sum = firstEven + value;
            System.out.println("Thread2:" + sum);
            firstEven = null;
        }
    }
}
