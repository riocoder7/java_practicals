abstract class Shape {
    // Abstract method for calculating area
    public abstract double area();
}

// Concrete subclass - Circle
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

public class _2b {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0);
        // Create a Circle object
        // Calculate and display the area of the circle
        System.out.println("Circle Area: " + circle.area());
    }
}
