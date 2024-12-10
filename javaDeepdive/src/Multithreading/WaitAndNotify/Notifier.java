package Multithreading.WaitAndNotify;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable{

    private Message message;

    public Notifier (Message message) {
        this.message = message;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            // this sleep() is to ensure that the reader objects can capture the monitor first
            TimeUnit.MILLISECONDS.sleep(500);
            synchronized (message) {
                message.setMessage(name + " Notifier work done");
                //message.notify();
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Notifier has finished.");
    }
}
