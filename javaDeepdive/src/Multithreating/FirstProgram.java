package Multithreating;

public class FirstProgram {

    public static void main (String[] args) {

        Runnable task = new DefaultRunnable();
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
    }
}
