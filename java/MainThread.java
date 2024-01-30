class MyThread extends Thread {
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getId() + " is running.");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getId() + " is running.");
    }
}

public class MainThread {
    public static void main(String[] args) {
        // Creating and starting a thread using the Thread class
        MyThread thread1 = new MyThread();
        thread1.start();

        // Creating and starting a thread using the Runnable interface
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        // Creating and starting a thread using an anonymous inner class
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getId() + " is running.");
            }
        });
        thread3.start();

        // Creating and starting a thread using lambda expression
        Thread thread4 = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getId() + " is running.");
        });
        thread4.start();
    }
}
