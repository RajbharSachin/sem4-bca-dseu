class Shape {
    public void displayShape() {
        System.out.println("This is shape ");
    }
}

class Rectangle extends Shape {
    public void displayRectangle() {
        System.out.println("This is rectangle shape ");
    }
}

class Circle extends Shape {
    public void displayCircle() {
        System.out.println("This is circle shape ");
    }
}

class Square extends Rectangle {
    public void displaySquare() {
        System.out.println("Rectangle and square ");
    }
}

public class temp {
    public static void main(String[] args) {
        Square obj = new Square();
        obj.displayShape();
        obj.displayRectangle();
        obj.displaySquare();
    }
}