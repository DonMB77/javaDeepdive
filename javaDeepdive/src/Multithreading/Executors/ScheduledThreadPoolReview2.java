package Multithreading.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolReview2 {

    public static void main(String[] args) throws InterruptedException {
        var executorService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Hello");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 500, 1000, TimeUnit.MILLISECONDS);

        executorService.awaitTermination(7, TimeUnit.SECONDS);
        executorService.shutdownNow();

        System.out.println("/////////////////////");

        var executorService2 = Executors.newScheduledThreadPool(4);

        executorService2.scheduleWithFixedDelay(() -> {
            System.out.println("Hello");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 500, 1000, TimeUnit.MILLISECONDS);

        executorService2.awaitTermination(7, TimeUnit.SECONDS);
        executorService2.shutdownNow();
    }
}

