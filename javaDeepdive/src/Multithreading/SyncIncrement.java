package Multithreading;

import java.util.ArrayList;

public class SyncIncrement {

    private static int counter;

    public static void main (String[] args) throws InterruptedException {
        ArrayList<Thread> allThreadsList = new ArrayList<>();
        int numberOfIncrementsAndThreads = 10000;

        for (int i = 0; i < numberOfIncrementsAndThreads; i++) {
            var t = new Thread(SyncIncrement::increment);
            allThreadsList.add(t);
            t.start();
        }
        for (Thread thread : allThreadsList) {
            thread.join();
        }

        // this now consistently (every time) prints 10000
        System.out.println(counter);
    }

    // synchronized doesn't allow access to block of code simultaneously.
    public synchronized static void increment() {
        counter++;
    }

    // example with synchronized block
    public static void incrementWithSyncBlock() {
        // we capture a monitor of the class to create a synchronized block.
        // Here we have to reference to a class where to capture a monitor.
        // Therefor only one thread can enter this block. Not the entire method might be a critical section.
        synchronized (SyncIncrement.class) {
            counter++;
        }
    }
}
