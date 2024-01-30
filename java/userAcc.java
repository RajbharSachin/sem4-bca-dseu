import java.util.Scanner;
class Account {
    int accno;
    String name;
    int amount=0;
    Account (int a, String n, int amt) {
        accno = a;
        name = n;
        amount = amt;
    }
    void insert(int a, String n, int amt) {
        accno = a;
        name = n;
        amount = amt;
    }
    void deposit(int amt) {
        amount = amount + amt;
        System.out.println(amt + " deposited");
    }
    void withdraw(int amt) {
        if(amount < amt){
            System.out.println("Insufficient Balance");
        } else {
            amount = amount - amt;
            System.out.println(amt + " withdrawn");       
        }
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Account number: " + accno);
        System.out.println("Ac Balance: " + amount);
    }
}

class userAcc {
    
    public static void main(String[] args) {
        Account a1 = new Account(1677, "Mr. Ravindra", 1000000000);
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            
            System.out.println("\n\nWelcome to the RAKA Bank\n");
            System.out.println("Please select an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            
            
            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = sc.next();
                    System.out.println("Enter your account number: ");
                    int accno = sc.nextInt();
                    System.out.println("Enter the amount you want to deposit: ");
                    int amt = sc.nextInt();
                    
                    a1.insert(accno, name, amt);
                    System.out.println("Account created successfully");
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit: ");
                    int deposit = sc.nextInt();
                    a1.deposit(deposit);
                    break;
                case 3:
                    System.out.println("Enter the amount you want to withdraw: ");
                    int withdraw = sc.nextInt();
                    a1.withdraw(withdraw);
                    break;
                case 4:
                    a1.display();
                    break;
                case 5:
                    System.out.println("Thank you for using RAKA Bank");
                    ch = 'n';
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Do you want to continue? (y/n)");
            ch = sc.next().charAt(0);
        } while (ch == 'y'|| ch == 'Y');
    }
}