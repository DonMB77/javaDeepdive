package Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteUsingExecutorServices {

    public static void main (String[] args) {
        // there are a lot of different factory methods within the Executors type. They are flagged with the new word within their declaration
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println("This is the thread " + Thread.currentThread().getName()));
        executorService.execute(() -> System.out.println("This is the thread " + Thread.currentThread().getName()));
    }
}
