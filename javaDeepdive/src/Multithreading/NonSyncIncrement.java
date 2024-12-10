package Multithreading;

import java.util.ArrayList;

public class NonSyncIncrement {

    private static int counter;

    public static <List> void main (String[] args) throws InterruptedException {
        ArrayList<Thread> allThreads = new ArrayList<>();
        int numberOfIncrements = 10000;

        for (int i = 0; i < numberOfIncrements; i++) {
            var t = new Thread(NonSyncIncrement::increment);
            allThreads.add(t);
            t.start();
        }

        for (Thread thread : allThreads) {
            // this essentially makes the main thread wait, till all others are executed
            thread.join();
        }

        // The result here is not always 10000 like we would expect.
        // This happens since at some point in time, at least 2 threads entered the method simultaneously.
        // To fix this we need to make our increment() synchronous, so to speak.
        // That means we need to synchronize access of different threats towards our critical section, and not execute non-atomic operations
        System.out.println(counter);
    }

    public static void increment() {
        counter++;
    }
}
