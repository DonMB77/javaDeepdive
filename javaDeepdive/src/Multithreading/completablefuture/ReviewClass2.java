package Multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ReviewClass2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureResult = CompletableFuture.supplyAsync(() -> "Hello");
        System.out.println(futureResult.get());
    }
}
