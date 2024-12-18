package Multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReviewClass1 {

    public static void main (String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("For example, a http call might go here");
        });

        TimeUnit.SECONDS.sleep(2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture.runAsync(() -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("For example, a http call might go here");
        }, executorService);

        executorService.shutdown();
    }
}
