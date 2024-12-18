package Multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ReviewClass4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Request User Profile from external API...");
            return "Some String representation of User Profile";
        }).thenAccept((result) -> {
            System.out.println("User Profile Received: " + result);
        });

        // When not returning a value after thenAccept() we get a null value returned.
        System.out.println(future.get());

        var es = Executors.newCachedThreadPool();
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Request User Profile from external API...");
            return "Some String representation of User Profile";
        }).thenAcceptAsync((result) -> {
            System.out.println("User Profile Received: " + result);
        }, es);

        es.shutdown();
    }
}
