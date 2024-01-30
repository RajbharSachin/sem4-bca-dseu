public class TablePrinter {
    public synchronized void printTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
            try {
                Thread.sleep(500); // Simulating some work being done by the thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TableThread extends Thread {
    private final TablePrinter tablePrinter;
    private final int number;
    
    public TableThread(TablePrinter printer, int num) {
        tablePrinter = printer;
        number = num;
    }
    
    public void run() {
        tablePrinter.printTable(number);
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        TablePrinter printer = new TablePrinter();
        
        TableThread thread1 = new TableThread(printer, 2);
        TableThread thread2 = new TableThread(printer, 5);
        
        thread1.start();
        thread2.start();
    }
}