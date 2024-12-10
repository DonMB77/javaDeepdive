package Multithreading.DeadlockLivelock;

import java.util.concurrent.TimeUnit;

/*
    This class correctly implements the problem looked at by DeadlockIssue
 */

public class DeadlockSolution {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main (String[] args) {


        /*
        The order of the capturing is now the same, therefor the locks will not lock each other out.
         */
        new Thread(() -> {
            synchronized (lock1)  {
                System.out.println("lock1 is captured");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {
                    System.out.println("This block will now be reached.");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("lock2 is captured");
                synchronized (lock2) {
                    System.out.println("This block will now be reached.");
                }
            }
        }).start();
    }
}
