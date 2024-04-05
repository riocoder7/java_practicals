// Define an interface
interface Shape {
    // Abstract methods (implicitly public and abstract)
    double area();
    double perimeter();
}

// Implement the interface in a class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

public class _2c {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0); // Create a Circle object
        // Calculate and display the area and perimeter of the circle
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());
    }
}
