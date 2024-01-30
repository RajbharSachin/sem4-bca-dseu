class  sum {
    int a , b, c ;
    void insert(int x, int y,int z) {
        a= x ;
        b=y ;       
         c= z ;
    }
    void calculatesum (){
        System.out.println("Sum is :"+a+b+c);
    }

    void calculateproduct(){
        System.out.println("Product is :"+a*b*c);
    }
    void calculateavg(){
        System.out.println(("Average is :"+(a+b+c)/3));
    }
}

public class sumAvgProOf3 {
    public static void main(String[] args){
        sum s1 =new sum();
        sum s2 =new sum();
        sum s3 =new sum();

        s1.insert(10 ,34,56);
        s2.insert(23,45,67);
        s3.insert(10,20,30);
        s1.calculatesum();
        s2.calculateproduct();
        s3.calculateavg();

    }
}