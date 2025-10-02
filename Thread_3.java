// Шушка привет, это твой первый поток (первое условие)

public class Thread_3 extends Thread {
    private int threadnumber;
    public Thread_3(int threadnumber) {
        this.threadnumber = threadnumber;
    }
    @Override
    public void run() {
        System.out.println("Hello World от потока №" + threadnumber);
    }
}
