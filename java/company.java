class company_database {
    char name;
    int age, phno, company_id, salary;
    void printSalary() {
        System.out.println("Salary is "+salary);
    }
}

class employee extends company_database {
    char core_area;
}

class manager extends company_database {
    char branch;
}

public class company {

    public static void main(String[] args) {
        //object e1
        employee e1 = new employee();
        e1.name = 'A';
        e1.age = 20;
        e1.phno = 1234567890;
        e1.company_id = 1;
        e1.salary = 10000000;
        e1.core_area = 'B';
        e1.printSalary();
        
        //object m1
        manager m1 = new manager();
        m1.name = 'C';
        m1.age = 30;
        m1.phno = 1234567890;
        m1.company_id = 2;
        m1.salary = 20000000;
        m1.branch = 'D';
        m1.printSalary();
    }
}
