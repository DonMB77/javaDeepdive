package Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadFactoryReview {

    public static void main (String[] args) {
        int numberOfThreads = 4;
        var executorService = Executors.newFixedThreadPool(numberOfThreads, new DefaultThreadFactory());

        IntStream.range(0, numberOfThreads).forEach(i -> {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        });

        executorService.shutdown();
    }
}

// demo of an implementation of ThreadFactory
class DefaultThreadFactory implements ThreadFactory {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Our custom thread factory | thread #" + counter.getAndIncrement());
    }
}
