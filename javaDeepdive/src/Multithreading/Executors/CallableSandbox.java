package Multithreading.Executors;

import java.util.concurrent.*;

public class CallableSandbox {

    public static void main (String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(() -> 1 + 1);

        // This waits if necessary for at most the given time for the computation to complete, and then retrieves its result, if available.
        System.out.println(future.get(10, TimeUnit.SECONDS));
    }
}
