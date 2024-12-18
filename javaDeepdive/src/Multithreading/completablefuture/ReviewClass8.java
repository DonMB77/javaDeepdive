package Multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ReviewClass8 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "First")
                .thenAcceptBoth(CompletableFuture
                        .supplyAsync(() -> " Second"), (s1, s2) -> System.out.println(s1 + s2));
        System.out.println(future.get());
    }
}