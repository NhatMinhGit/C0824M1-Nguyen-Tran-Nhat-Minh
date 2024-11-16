public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    // Constructor không tham số
    public Triangle() {
        super();
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    // Constructor có tham số
    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getter và Setter cho side1, side2, side3
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // Tính diện tích
    public double getArea() {
        double s = getPerimeter() / 2; // Nửa chu vi
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Tính chu vi
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Triangle: side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 +
                ", " + super.toString();
    }
}
