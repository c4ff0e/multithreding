

public class Thread_4 extends Thread {
    private final int threadnumber;
    private final int[] randomMassive;
    public Thread_4(int threadnumber, int[] randomMassive) {
        this.threadnumber = threadnumber;
        this.randomMassive = randomMassive;
    }
    @Override
    public void run() {
        System.out.println("Hello World от потока №" + threadnumber + " " + randomMassive[0]);
    }
}
