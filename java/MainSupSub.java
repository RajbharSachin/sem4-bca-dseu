class Shape {
    public double area() {
        return 0; // Default implementation for unknown shapes
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class MainSupSub {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4, 5);
        System.out.println("Area of Rectangle: " + rectangle.area());

        Shape triangle = new Triangle(4, 5);
        System.out.println("Area of Triangle: " + triangle.area());

        Shape circle = new Circle(3.5);
        System.out.println("Area of Circle: " + circle.area());
    }
}
