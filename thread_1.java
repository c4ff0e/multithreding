public class Thread_1 extends Thread {
    private int threadnumber;
    public Thread_1(int threadnumber) {
        this.threadnumber = threadnumber;
    }
    @Override
    public void run() {
        System.out.println("Hello World от потока №" + threadnumber);
    }
}
