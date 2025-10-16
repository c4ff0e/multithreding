import java.util.Random;

// Класс Counter реализует интерфейс Runnable, чтобы его объекты можно было запускать в потоках
class Counter implements Runnable {
    private int[] mas;  // массив чисел
    private int from, to, step; // диапазон индексов для прохода и шаг

    // Конструктор класса Counter
    public Counter(int from, int to, int step, int[] mas) {
        this.from = from;   // стартовый индекс
        this.to = to;       // конечный индекс
        this.step = step;   // шаг (может быть +1 или -1)
        this.mas = mas;     // ссылка на массив чисел
    }

    // Метод run() запускается при старте потока
    public void run() {
        int i = from;
        while (true) {
            // Проверяем условие выхода из цикла
            if (step > 0 && i >= to) break;  // если идём вперед и достигли конца
            if (step < 0 && i <= to) break;  // если идём назад и достигли начала

            // Проверяем, является ли текущее число нечётным
            if (mas[i] % 2 != 0) {
                int j = i + step;  // следующий индекс в направлении шага
                // Проверяем, что индекс j внутри массива и число нечётное
                if (j >= 0 && j < mas.length && mas[j] % 2 != 0) {
                    int product = mas[i] * mas[j]; // вычисляем произведение двух нечётных чисел
                    System.out.println(Thread.currentThread().getName() +
                            " произведение нечётных чисел: " + mas[i] + " * " + mas[j] +
                            " = " + product + " (позиции " + i + " и " + j + ")");
                }
            }
            i += step; // двигаемся на следующий индекс
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] mas = new int[100];  // создаём массив на 100 элементов
        Random rand = new Random(); // объект для генерации случайных чисел

        // Заполняем массив случайными числами от 1 до 100 и выводим его на экран
        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(100) + 1; // rand.nextInt(100) даёт 0-99, +1 → 1-100
            System.out.print(mas[i] + " ");
        }
        System.out.println("\n");

        // Создаём два объекта Counter: один идёт с начала массива к концу, второй — с конца к началу
        Counter cnt1 = new Counter(0, mas.length - 1, 1, mas);      // от начала к концу
        Counter cnt2 = new Counter(mas.length - 1, 0, -1, mas);     // от конца к началу

        // Создаём потоки для этих объектов
        Thread th1 = new Thread(cnt1, "Поток 1");
        Thread th2 = new Thread(cnt2, "Поток 2");

        // Запускаем потоки
        th1.start();
        th2.start();

        // Ждём завершения потоков, чтобы основной поток (main) не продолжил раньше времени
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // После завершения потоков выводим информацию о авторе по одному символу с задержкой 100 мс
        String info = "Выполнила Еремеева Сусана (CR-233)";
        for (char c : info.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(100); } // небольшая задержка для эффектного вывода
            catch (InterruptedException ignored) {}
        }
    }
}
