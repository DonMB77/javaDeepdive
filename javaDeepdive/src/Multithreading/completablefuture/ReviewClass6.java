package Multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ReviewClass6 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<CompletableFuture<Double>> result = getUserDetailById(125)
                .thenApply(user -> getCreditRating(user));

        // this is cumbersome
        System.out.println(result.get().get());

        // using thenCompose() I get a CompletableFuture parameterised by the result of the second one.
        CompletableFuture<Double> result2 = getUserDetailById(125)
                .thenCompose(user -> getCreditRating(user));
        System.out.println(result2.get());
    }

    private static CompletableFuture<String> getUserDetailById(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            return "user details string";
        });
    }

    private static CompletableFuture<Double> getCreditRating(String userDetails) {
        return CompletableFuture.supplyAsync(() -> {
            return 110.98;
        });
    }
}
