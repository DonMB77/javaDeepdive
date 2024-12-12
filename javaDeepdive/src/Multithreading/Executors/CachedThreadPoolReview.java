package Multithreading.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CachedThreadPoolReview {

    public static void main (String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        IntStream.range(0,4).forEach(i -> {
            threadPoolExecutor.submit(() -> {
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            });
        });
        threadPoolExecutor.shutdown();

        System.out.println("Pool size of " + threadPoolExecutor.getPoolSize());
        // since we use synchronous queue in newCachedThreadPool() the queue size is now 0
        System.out.println("Queue size of " + threadPoolExecutor.getQueue().size());
    }
}
