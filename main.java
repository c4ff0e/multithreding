public class Main {
    public static void main(String[] args) {
// TODO: меню, выбор двух тредов
        
        Thread_1 thread1 = new Thread_1(1);
        Thread_2 thread2 = new Thread_2(2);
        Thread_3 thread3 = new Thread_3(3);
        Thread_4 thread4 = new Thread_4(4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}