
public class Thread_3 extends Thread {
    private final int threadnumber;
    private final int[] randomMassive;
    public Thread_3(int threadnumber, int[] randomMassive) {
        this.threadnumber = threadnumber;
        this.randomMassive = randomMassive;
    }
    @Override
    public void run() {
        System.out.println("Hello World от потока №" + threadnumber + " " + randomMassive[1]);
    }
}
