package Multithreading.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class FixedThreadPoolReview {

    public static void main(String[] args) {
        // factory method newFixedThreadPool() returns ExecutorService. It is recommended to work on that level of abstraction here.
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        IntStream.range(0, 4).forEach(i -> {
            threadPoolExecutor.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        threadPoolExecutor.shutdown();

        System.out.println("Pool Size of: " + threadPoolExecutor.getPoolSize()); // 3 since Executors.newFixedThreadPool(3)
        System.out.println("Queue size of: " + threadPoolExecutor.getQueue().size()); // 1 since only Executors.newFixedThreadPool(3) and 4 submitted

        int numberOfAvailableCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors: " + numberOfAvailableCores);

        // this initialization can also be used. but depending on different reasons for used cores, this might not be the way to go
        var threadPoolExecutor2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
