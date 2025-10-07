import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] randomMassive = new int[100];
        Random random = new Random();
        for (int i = 0; i < randomMassive.length; i++) {
            randomMassive[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(randomMassive));
 

// TD: меню, выбор двух тредов
        
        Thread_1 thread1 = new Thread_1(1, randomMassive);
        Thread_2 thread2 = new Thread_2(2, randomMassive);
        Thread_3 thread3 = new Thread_3(3, randomMassive);
        Thread_4 thread4 = new Thread_4(4, randomMassive);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбор варианта: 1 - Thread1 и Thread2 (вариант 8), 2 - Thread3 и Thread4 (вариант 7)");
        int choice = scanner.nextInt();
        scanner.close();
        if (choice == 1) {
        thread1.start();
        thread2.start();
        } else if (choice == 2) {
            thread3.start();
            thread4.start();
        }
    }
}

