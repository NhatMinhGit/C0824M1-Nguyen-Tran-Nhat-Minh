import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Nhập các cạnh từ người dùng
            System.out.println("Nhập cạnh thứ nhất: ");
            double side1 = scanner.nextDouble();

            System.out.println("Nhập cạnh thứ hai: ");
            double side2 = scanner.nextDouble();

            System.out.println("Nhập cạnh thứ ba: ");
            double side3 = scanner.nextDouble();

            // Tạo đối tượng Triangle và kiểm tra
            Triangle triangle = new Triangle(side1, side2, side3);
            triangle.display();
        } catch (IllegalTriangleException e) {
            System.err.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi nhập liệu. Hãy nhập số hợp lệ.");
        } finally {
            scanner.close();
        }
    }
}