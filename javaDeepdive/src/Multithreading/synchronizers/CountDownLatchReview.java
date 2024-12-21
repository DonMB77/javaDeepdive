package Multithreading.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLatchReview {

    private static final int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        var executorService = Executors.newFixedThreadPool(2);

        IntStream.range(0, COUNT).forEach(i -> executorService.submit(new Worker(countDownLatch)));

        countDownLatch.await();
        System.out.println("Latch is released");

        executorService.shutdown();
    }

    private static class Worker implements Runnable {

        private CountDownLatch countDownLatch;

        public Worker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public void run () {
            System.out.println("doing dome work...");
            System.out.println("Counted down -1");
            countDownLatch.countDown();
        }
    }
}
