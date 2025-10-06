

public class Thread_4 extends Thread {
    private final int threadnumber;
    private final int[] randomMassive;
    public Thread_4(int threadnumber, int[] randomMassive) {
        this.threadnumber = threadnumber;
        this.randomMassive = randomMassive;
    }
    @Override
    public void run() {
        Integer firstEven = null;
        System.out.println("Hello World от потока №" + threadnumber + " " + randomMassive[0]);
        for (int i = 0; i < randomMassive.length; i++) {
            int value = randomMassive[i];
            if (value % 2 != 0) {
                continue;} 

           if (firstEven == null) {
            firstEven = value;
            continue;
           }
           int sum = firstEven + value;
           System.out.println(sum);
           firstEven = null;
        }
        
    }
}

