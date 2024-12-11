package Multithreading.Executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class InvokeAnyPreview {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
                () -> {
                    TimeUnit.MILLISECONDS.sleep(500);
                    return "Task 1";
                },
                () -> {
                    TimeUnit.MILLISECONDS.sleep(100);
                    return "Task 2";
                },
                () -> {
                    TimeUnit.MILLISECONDS.sleep(300);
                    return "Task 3";
                }
        ));

        // also has another overloaded method that takes a timeout and unit so a time limit can be implemented
        String result = executorService.invokeAny(tasks);

        // prints task 2 since it has the slowest time out
        System.out.println(result);
    }
}
