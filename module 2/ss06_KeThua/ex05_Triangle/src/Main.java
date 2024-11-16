import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập độ dài ba cạnh
        System.out.print("Nhập cạnh thứ nhất: ");
        double side1 = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ hai: ");
        double side2 = scanner.nextDouble();

        System.out.print("Nhập cạnh thứ ba: ");
        double side3 = scanner.nextDouble();

        // Nhập màu sắc và trạng thái filled
        System.out.print("Nhập màu sắc của tam giác: ");
        String color = scanner.next();

        System.out.print("Tam giác có đầy (filled) hay không (true/false): ");
        boolean filled = scanner.nextBoolean();

        // Tạo đối tượng Triangle
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Hiển thị thông tin
        System.out.println("Thông tin tam giác:");
        System.out.println(triangle);
        System.out.println("Diện tích: " + triangle.getArea());
        System.out.println("Chu vi: " + triangle.getPerimeter());

        scanner.close();
    }
}

