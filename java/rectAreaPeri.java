class Rectangle {
    int length;
    int breadth;
    void insert(int l, int b) {
        length = l;
        breadth = b;
    }
    int calcArea() {
        return length * breadth;
    }
    int calcPeri() {
        return 2 *(length + breadth);
    }
}

public class rectAreaPeri {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        r1.insert(15, 20);
        r2.insert(50,125);
        System.out.println("Area of rectangle1 is: " + r1.calcArea());
        System.out.println("Perimeter of rectangle1 is: " + r1.calcPeri());
        System.out.println("Area of rectangle2 is: " + r2.calcArea());
        System.out.println("Perimeter of rectangle2 is: " + r2.calcPeri());

    }
}