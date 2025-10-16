import java.util.Random;
class Counter implements Runnable {
    private int[] mas;
    private int from, to, step;

    public Counter(int from, int to, int step, int[] mas) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.mas = mas;
    }

    public void run() {
        int i = from;
        while (true) {
            if (step > 0 && i >= to) break;
            if (step < 0 && i <= to) break;

            if (mas[i] % 2 != 0) {
                int j = i + step;
                if (j >= 0 && j < mas.length && mas[j] % 2 != 0) {
                    int product = mas[i] * mas[j];
                    System.out.println(Thread.currentThread().getName() +
                            " произведение нечётных чисел: " + mas[i] + " * " + mas[j] +
                            " = " + product + " (позиции " + i + " и " + j + ")");
                }
            }
            i += step;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] mas = new int[100];
        Random rand = new Random();

        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(100) + 1;
            System.out.print(mas[i] + " ");
        }
        System.out.println("\n");

        Counter cnt1 = new Counter(0, mas.length - 1, 1, mas);      // от начала к концу
        Counter cnt2 = new Counter(mas.length - 1, 0, -1, mas);     // от конца к началу

        Thread th1 = new Thread(cnt1, "Поток 1");
        Thread th2 = new Thread(cnt2, "Поток 2");

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String info = "Выполнила Еремеева Сусана (CR-233)";
        for (char c : info.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(100); }
            catch (InterruptedException ignored) {}
        }
    }
}// sssss
