package Multithreading;

public class FirstProgram extends Thread{

    public static void main (String[] args) {

        Runnable task = new DefaultRunnable();
        Thread thread1 = new Thread(task);

        // you can also use an anonymous class. This however is not very popular.
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is a new thread. My name is " + Thread.currentThread().getName());
            }
        });

        // This is often referenced in literature. But not the best approach due to single responsibility principle.
        Thread thread3 = new FirstProgram();

        // Here we use Lambda-Expression to implement run()
        Thread thread4 = new Thread(() -> System.out.println("This is a new thread. My name is " + Thread.currentThread().getName()));

        Thread thread5 = new Thread(FirstProgram::execute);

        System.out.println("This is a new thread. My name is " + Thread.currentThread().getName());
        thread1.run(); // This doesn't start the thread. Only start() does that. There might not be a lot of sense in just calling run().

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


    // here we override the run method of Runnable. This makes us able to create a new thread as seen with thread3
    @Override
    public void run() {
        System.out.println("This is a new thread. My name is " + Thread.currentThread().getName());
    }

    // meets the definition of runnable interface. It doesn't take any arguments and returns nothing.
    public static void execute(){
        System.out.println("This is a new thread. My name is " + Thread.currentThread().getName());
    }
}

class DefaultRunnable implements Runnable {

    private String extString;

    public DefaultRunnable() {

    }

    public DefaultRunnable(String extString) {
        this.extString = extString;
    }

    @Override
    public void run() {
        System.out.println("This is a new thread. My name is " + Thread.currentThread().getName());
        // of course fields of the class can be used here as well
    }
}
