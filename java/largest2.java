import java.util.Scanner;

public class largest2 {
   public static void main(String[] args)
   {
      int num1, num2, largest;
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter the First Number: ");
      num1 = scan.nextInt();
      System.out.print("Enter the Second Number: ");
      num2 = scan.nextInt();
      
      scan.close();
    if(num1>num2){
         largest = num1;
         System.out.println("\nLargest = " +largest);

    }else if(num1<num2){
        largest = num2;
        System.out.println("\nLargest = " +largest);
    }
    else
    {
        System.out.println("\nBoth are same");
    }
   }
}