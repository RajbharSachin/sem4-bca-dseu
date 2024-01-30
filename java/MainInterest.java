import java.util.Scanner;

class RBI {
    protected double rateOfInterest;

    public RBI(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double calculateInterest(double principal, int years) {
        return (principal * rateOfInterest * years) / 100;
    }
}

class BankA extends RBI {
    public BankA(double rateOfInterest) {
        super(rateOfInterest);
    }

    @Override
    public double calculateInterest(double principal, int years) {
        return super.calculateInterest(principal, years);
    }
}

class BankB extends RBI {
    public BankB(double rateOfInterest) {
        super(rateOfInterest);
    }

    @Override
    public double calculateInterest(double principal, int years) {
        return super.calculateInterest(principal, years);
    }
}

class BankC extends RBI {
    public BankC(double rateOfInterest) {
        super(rateOfInterest);
    }

    @Override
    public double calculateInterest(double principal, int years) {
        return super.calculateInterest(principal, years);
    }
}

public class MainInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        RBI bankA = new BankA(8.0);
        double interestA = bankA.calculateInterest(principal, years);
        System.out.println("Simple interest for Bank A: " + interestA);

        RBI bankB = new BankB(9.0);
        double interestB = bankB.calculateInterest(principal, years);
        System.out.println("Simple interest for Bank B: " + interestB);

        RBI bankC = new BankC(7.2);
        double interestC = bankC.calculateInterest(principal, years);
        System.out.println("Simple interest for Bank C: " + interestC);
    }
}
