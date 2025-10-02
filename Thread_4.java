// Шушка привет, это твой второй поток (второе условие)

public class Thread_4 extends Thread {
    private int threadnumber;
    public Thread_4(int threadnumber) {
        this.threadnumber = threadnumber;
    }
    @Override
    public void run() {
        System.out.println("Hello World от потока №" + threadnumber);
    }
}
