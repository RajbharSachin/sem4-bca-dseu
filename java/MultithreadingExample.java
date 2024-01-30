public class MultithreadingExample extends Thread {
    private final String threadName;
    
    public MultithreadingExample(String name) {
        threadName = name;
        System.out.println("Creating thread: " + threadName);
    }
    
    public void run() {
        System.out.println("Running thread: " + threadName);
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + threadName + " is executing iteration " + i);
                Thread.sleep(1000); // Simulating some work being done by the thread
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
    
    public static void main(String[] args) {
        MultithreadingExample thread1 = new MultithreadingExample("Thread 1");
        MultithreadingExample thread2 = new MultithreadingExample("Thread 2");
        
        // Start the threads
        thread1.start();
        thread2.start();
    }
}