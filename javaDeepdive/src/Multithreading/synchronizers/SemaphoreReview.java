package Multithreading.synchronizers;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreReview {

    public static void main (String[] args) throws InterruptedException {
        int loginPermits = 10;
        var executorService = Executors.newFixedThreadPool(4);
        var demo = new SemaphoreReview(loginPermits);
        IntStream.range(0, loginPermits).forEach(user -> executorService.submit(demo::tryLogin));
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("AvailablePermitsForLogin: " + demo.availablePermitsForLogin());
        demo.tryLogin();

        demo.logout();
        System.out.println("AvailablePermitsForLogin: " + demo.availablePermitsForLogin());
    }

    private Semaphore semaphore;

    public SemaphoreReview(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    private void tryLogin() {
        if (semaphore.tryAcquire()) {
            System.out.println("You have successfully logged in");
        } else {
            System.out.println("No permits for login available as of this moment. Try again later.");
        }
    }

    private void logout() {
        semaphore.release();
    }

    private int availablePermitsForLogin() {
        return semaphore.availablePermits();
    }
}
