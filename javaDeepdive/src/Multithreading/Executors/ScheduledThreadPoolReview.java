package Multithreading.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolReview {

    public static void main(String[] args) {
        var executorService = Executors.newScheduledThreadPool(4);
        executorService.schedule(() -> System.out.println("Schedule example " +
                Thread.currentThread().getName()), 1, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}

// demo ThreadFactory... not used!
class CustomThreadFactory implements ThreadFactory {
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        atomicInteger.getAndIncrement();
        return new Thread(() -> System.out.println("Counter: " + atomicInteger));
    }
}
