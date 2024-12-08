package Multithreading;

import java.util.concurrent.TimeUnit;

public class DaemonThread {

    public static void main (String[] args) throws InterruptedException {

        var thread0 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("Daemon is working");
                } catch (InterruptedException e) {

                }
            }
        });

        thread0.setDaemon(true);
        thread0.start();

        // since the main thread is finished here, and only daemon threads remain, they are terminated automatically.
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Main thread is finished.");
    }
}
