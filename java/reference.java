class student1{
    int id ;
    String name ;
}


public class reference {
    public static void  main(String[] args) {
        student1 s1= new student1();
        s1.id =109;
        s1.name="Aman";
        System.out.println(s1.id+"\n"+s1.name);
    }
}