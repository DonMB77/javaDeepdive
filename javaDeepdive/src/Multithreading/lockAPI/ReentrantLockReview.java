package Multithreading.lockAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * A lock is called reentrant if the thread that can lock() can also unlock()
 */
public class ReentrantLockReview {

    // this is our shared resource
    private static int counter;

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        var thisInstance = new ReentrantLockReview();
        var executorService = Executors.newFixedThreadPool(4);
        IntStream.range(0, 10000).forEach(i -> executorService.execute(thisInstance::incrementWithLock));
        terminateExecutorService(executorService);

        System.out.println(counter);
    }

    // unlocked method should always be invoked in a finally block
    // if an exception where to happen, we might never execute unlock() and enter a deadlock state
    public void incrementWithLock() {
        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }
    }
    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    private static void terminateExecutorService (ExecutorService executorService) throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }
}
