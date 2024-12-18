package Multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ReviewClass3 {
    /*
    Here a sequence of steps that should be executed one after another in a separate thread.
    Sometimes you might need to perform another action based of the completion of the previous step.
    So you can use a CompletableFuture, which should automatically get called once the future is complete.
    TODO: Research Callbacks.
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // you can chain thenApply multiple times, and chain the result of the previous step to further compute
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Request User ID from API...");
            return 1234;
        }).thenApply((result) -> {
            System.out.println("Request total number of purchases in other service by ID...");
            return 150;
        });

        System.out.println(future.get());

        /*
        Difference thenApply() and thenApplyAsync():
        thenApplyAsync() utilizes an Executor as it is used to execute tasks. thenApply() uses the same thread
        as was used by the first task and uses the same Executor as defined by the CompletableFuture on which it was called.
        thenApplyAsync() uses an independent Executor.
         */

        var executorService = Executors.newCachedThreadPool();
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Request User ID from external API...");
            return 1234;
        }).thenApplyAsync((result) -> {
            System.out.println("Request total number of purchases in other service by ID...");
            return 150;
        }, executorService);

        executorService.shutdown();
    }
}
