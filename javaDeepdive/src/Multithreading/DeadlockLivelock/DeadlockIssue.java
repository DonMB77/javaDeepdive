package Multithreading.DeadlockLivelock;

import java.util.concurrent.TimeUnit;

/*
    This class is used as an example of deadlocking.
    This class cannot run correctly and is not supposed to.
 */

public class DeadlockIssue {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main (String[] args) {


        /*
        Since both threads will be waiting for their allowed captured of either lock1 oder lock2, these will never close.
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
                    System.out.println("This block will never be reached.");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("lock2 is captured");
                synchronized (lock1) {
                    System.out.println("This block will never be reached.");
                }
            }
        }).start();
    }
}
