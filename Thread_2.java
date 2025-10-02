public class Thread_2 extends Thread {
    private int threadnumber;
    public Thread_2(int threadnumber) {
        this.threadnumber = threadnumber;
    }
    @Override
    public void run() {
        System.out.println("Hello World от потока №" + threadnumber);
    }
}
