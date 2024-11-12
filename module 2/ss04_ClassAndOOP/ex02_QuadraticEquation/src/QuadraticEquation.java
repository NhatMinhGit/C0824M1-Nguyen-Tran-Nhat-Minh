import java.util.Scanner;

public class QuadraticEquation {
    private static double a, b, c;

    // Phương thức khởi tạo
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Getter cho a, b, c
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    // Tính và trả về delta
    public static double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    // Tính và trả về nghiệm 1
    public static double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        }
        return 0;  // Nếu delta < 0 thì không có nghiệm
    }

    // Tính và trả về nghiệm 2
    public static double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.sqrt(delta)) / (2 * a);
        }
        return 0;  // Nếu delta < 0 thì không có nghiệm
    }

    // Phương thức kiểm tra nghiệm
    public static void displayRoots() {
        double delta = getDiscriminant();
        if (delta > 0) {
            System.out.println("The equation has two roots: " + getRoot1() + " and " + getRoot2());
        } else if (delta == 0) {
            System.out.println("The equation has one root: " + getRoot1());
        } else {
            System.out.println("The equation has no roots.");
        }
    }
}