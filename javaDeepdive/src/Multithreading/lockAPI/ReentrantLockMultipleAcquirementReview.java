package Multithreading.lockAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Here we acquire the same lock multiple times in the same thread as a demo
 */
public class ReentrantLockMultipleAcquirementReview {

    private Lock lock = new ReentrantLock();

    public static void main (String[] args) throws InterruptedException {
        var demoInstance = new ReentrantLockMultipleAcquirementReview();
        var executorService = Executors.newFixedThreadPool(4);

        executorService.execute(() -> System.out.println(demoInstance.calculate("+", 2, 3)));
        executorService.execute(() -> System.out.println(demoInstance.calculate("+", 7, 12)));
        executorService.execute(() -> System.out.println(demoInstance.calculate("+", 87, 4)));

        executorService.execute(() -> System.out.println(demoInstance.calculate("-", 2, 3)));
        executorService.execute(() -> System.out.println(demoInstance.calculate("-", 2, 3)));
        executorService.execute(() -> System.out.println(demoInstance.calculate("-", 2, 3)));

        terminateExecutorService(executorService);
    }

    public double addDouble (double value1, double value2) {
        try {
            lock.lock();
            System.out.println("Lock is in effect");

            return value1 + value2;
        } finally {
            lock.unlock();
            System.out.println("Lock is released");
        }
    }

    public double subtractDouble (double value1, double value2) {
        try {
            lock.lock();
            System.out.println("Lock is in effect");

            return value1 - value2;
        }
        finally {
            lock.unlock();
            System.out.println("lock is released");
        }
    }

    public double calculate (String operation, double operand1, double operand2) {
        try {
            lock.lock();
            System.out.println("lock is acquired");

            switch (operation) {
                case "+":
                    return addDouble(operand1, operand2);
                case "-":
                    return subtractDouble(operand1, operand2);
                default:
                    System.out.println("Calculate works only with + and - operators and two values given.");
                    return 0;
            }
        } finally {
            lock.unlock();
            System.out.println("Lock has been released");
        }
    }

    private static void terminateExecutorService (ExecutorService executorService) throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }
}
