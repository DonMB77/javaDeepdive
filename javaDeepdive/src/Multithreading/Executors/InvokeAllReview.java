package Multithreading.Executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllReview {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                () -> "task 1",
                () -> "task 1",
                () -> "task 1"
                ));

        List<Future<String>> futureList = executorService.invokeAll(tasks);

        futureList.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return "";
        }).forEach(System.out::println);
    }
}