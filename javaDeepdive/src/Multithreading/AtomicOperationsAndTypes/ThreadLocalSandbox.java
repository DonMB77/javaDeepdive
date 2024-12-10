package Multithreading.AtomicOperationsAndTypes;

import java.util.concurrent.TimeUnit;

public class ThreadLocalSandbox implements Runnable {

    //private static ThreadLocal<String> transactionID = ThreadLocal.withInitial(() -> "n/a");

    // this variable can interestingly be viewed as a map of sorts. In this map the thread is a key
    // and the value is the values hat we set our ThreadLocal variable as.
    private static ThreadLocal<Integer> transactionId = new ThreadLocal<>();

    public static void main (String[] args) {
        ThreadLocalSandbox runnable = new ThreadLocalSandbox();

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        transactionId.set((int) (Math.random() * 100));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(transactionId.get());
    }
}
