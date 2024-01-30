import  java.util.Scanner ;
class Calculate{
    int num;

    void result(int n){
        int digit;
        int sum =0;
        int product=1;
        for(num=n; num>0;){
            digit = num%10;
            sum = sum +digit;
            product = product * digit;
            num = num/10;

        }
        System.out.println("sum 5 digit  :"+ sum);
        System.out.println("product 5 digits :"+ product);
    }  
}

public class digitsSumPro {
    public static void main(String [] args) {
        Calculate c1=new Calculate();
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter a number :");
        int n =scan.nextInt();
        c1.result(n);
        scan.close();
    }
}
