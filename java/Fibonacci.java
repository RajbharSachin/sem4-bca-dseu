import java.util.Scanner;

class Fibonacci {
 
    // Function to print N Fibonacci Number
    static void Fibonacciseries(int N)
    {
        int num1 = 0, num2 = 1;
        int counter = 0;
        // Iterate till counter is N
        while (counter < N) {
 
            // Print the number
            System.out.print(num1 + " ");
 
            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        // Given Number N
        System.out.println("Enter value of N:");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        // Function Call
        Fibonacciseries(N);
    }
}