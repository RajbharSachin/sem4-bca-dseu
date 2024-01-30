class shape {
    void prints() {
        System.out.println("this is a shape");
    }
}
class rectangle extends shape{
    void printr() {
        System.out.println("this is a rectangular shape");
    }
}
class circle extends shape {
    void print() {
        System.out.println(" this is a circular shape");
    }
}
class square extends rectangle {
    void print() {
        System.out.println("square is a rectangle");
    }
}
public class multiple {
    public static void main(String[] args) {
        square s1 = new square();
        s1.prints();
        s1.printr();
    }
}
