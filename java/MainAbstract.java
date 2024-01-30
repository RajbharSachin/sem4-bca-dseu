abstract class Shape {
    protected int length;
    protected int width;

    public Shape(int length, int width) {
        this.length = length;
        this.width = width;
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    void printArea() {
        int area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    public Triangle(int length, int width) {
        super(length, width);
    }

    @Override
    void printArea() {
        int area = (length * width) / 2;
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super(0, 0); // length and width are not applicable for Circle
        this.radius = radius;
    }

    @Override
    void printArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

public class MainAbstract {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5);
        rectangle.printArea();

        Triangle triangle = new Triangle(4, 5);
        triangle.printArea();

        Circle circle = new Circle(3.5);
        circle.printArea();
    }
}
