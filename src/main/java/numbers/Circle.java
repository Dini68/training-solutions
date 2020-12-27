package numbers;

public class Circle {

    private int diameter;
    private final static double PI = 3.1415;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return diameter * PI;
    }

    public double area() {
        return diameter * diameter * PI / 4;
    }
}
