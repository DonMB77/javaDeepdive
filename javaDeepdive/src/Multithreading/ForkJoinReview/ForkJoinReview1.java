package Multithreading.ForkJoinReview;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinReview1 {

    public static void main (String[] args) {
        ForkJoinPool commonForkJoinPool = ForkJoinPool.commonPool();

        ForkJoinPool forkJoinPool1 = new ForkJoinPool(4);

        // this uses the Runtime.getRuntime().availableProcessors() int value, thus differs between setups.
        ForkJoinPool forkJoinPool2 = new ForkJoinPool();

        forkJoinPool2.invoke(new ExampleRecursiveAction(32));
    }
}
