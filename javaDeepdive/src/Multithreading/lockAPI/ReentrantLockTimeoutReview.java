package Multithreading.lockAPI;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTimeoutReview {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main (String[] args) throws InterruptedException {
        var executorService = Executors.newFixedThreadPool(2);

        executorService.execute(ReentrantLockTimeoutReview::doSomethingLong);
        executorService.execute(ReentrantLockTimeoutReview::doSomethingLong);

        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }

    private static void doSomethingLong() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println("lock is acquired: " + lock.isLocked());
                TimeUnit.SECONDS.sleep(3);
            } else {
                System.out.println("Thread did not acquire a lock: " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
