class TablePrinter {
    synchronized void printTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
            try {
                Thread.sleep(500); // Introducing a small delay for better visualization
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TableThread extends Thread {
    private TablePrinter tablePrinter;
    private int number;

    public TableThread(TablePrinter tablePrinter, int number) {
        this.tablePrinter = tablePrinter;
        this.number = number;
    }

    public void run() {
        tablePrinter.printTable(number);
    }
}

public class MainSync {
    public static void main(String[] args) {
        TablePrinter tablePrinter = new TablePrinter();

        TableThread thread1 = new TableThread(tablePrinter, 2);
        TableThread thread2 = new TableThread(tablePrinter, 5);

        thread1.start();
        thread2.start();
    }
}
