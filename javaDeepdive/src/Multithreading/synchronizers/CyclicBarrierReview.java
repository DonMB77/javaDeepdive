package Multithreading.synchronizers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CyclicBarrierReview {

    private static final int NUMBER_OF_THREADS = 4;
    private static final int NUMBERS_TO_BE_GENERATED = 3;
    private static final int MAX_RANDOM_NUMBER = 100;

    private static CyclicBarrier cyclicBarrier;
    private List<Integer> generatedNumbers = new CopyOnWriteArrayList<>();
    private Random r = new Random();

    public static void main (String[] args) throws InterruptedException {
        var demo = new CyclicBarrierReview();
        cyclicBarrier = new CyclicBarrier(NUMBER_OF_THREADS, demo::numberGeneratorCallback);

        var executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        IntStream.range(0, NUMBER_OF_THREADS).forEach(i -> executorService.submit(demo::generateNumbers));
        System.out.println("getParties(): " + cyclicBarrier.getParties());

        executorService.shutdownNow();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }

    private void numberGeneratorCallback () {
        int max = generatedNumbers.stream().mapToInt(i -> i).max().getAsInt();
        System.out.println("All generated numbers: " + generatedNumbers);
        System.out.println("Maximum " + max);
    }

    private void generateNumbers() {
        for (int i = 0; i < NUMBERS_TO_BE_GENERATED; i++) {
            generatedNumbers.add(r.nextInt(MAX_RANDOM_NUMBER+1));
        } try {
            System.out.println("await(): " + cyclicBarrier.await());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
