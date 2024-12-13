package Multithreading.ForkJoinReview;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinReview2 {

    public static void main (String[] args) {
        var pool = new ForkJoinPool();

        var result = pool.invoke(new ExampleRecursiveTask(20));
        System.out.println("Result: " + result);
    }
}
