package Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceInterruptedCase {

    public static void main (String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach((i) -> {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(i);
                    System.out.println("Task #" + i + " is completed");
                } catch (InterruptedException e) {
                    System.out.println("Task #" + i + " was interrupted");
                }
            });
        });

        System.out.println("Shutting down now!");
        // this makes ExecutorService unable to accept new tasks and shutdown after all running tasks are finished
        // therefor, in theory you can just call the following method and let ExecutorService finish their jobs
        executorService.shutdown();

        // Uncomment the following  line to see RejectedExecutionException
        //executorService.submit(() -> System.out.println("A new task will throw an exception after shutdown"));

        // the following algorithm his highly recommended to be implemented after shutdown()
        try {
            // during concurrent execution there might simply be some computations that take longer
            // this blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
            // This method does not wait for actively executing tasks to terminate. Use awaitTermination to do that.
            executorService.shutdownNow();
        }
    }
}
