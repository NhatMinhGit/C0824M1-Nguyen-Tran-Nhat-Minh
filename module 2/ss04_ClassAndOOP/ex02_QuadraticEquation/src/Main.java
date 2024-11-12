import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị cho a, b, c
        System.out.print("Enter value for a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter value for b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter value for c: ");
        double c = scanner.nextDouble();

        // Tạo đối tượng QuadraticEquation
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        // Hiển thị nghiệm
        equation.displayRoots();
    }
}