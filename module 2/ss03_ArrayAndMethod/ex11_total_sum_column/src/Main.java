import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 2: Thu thập kích thước của mảng từ người dùng
        System.out.print("Nhập số hàng của mảng: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int cols = scanner.nextInt();

        double[][] array = new double[rows][cols];

        // Nhập các giá trị cho mảng hai chiều
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextDouble();
            }
        }

        // Hỏi người dùng muốn tính tổng của cột nào
        System.out.print("Nhập số thứ tự của cột muốn tính tổng (tính từ 0): ");
        int colIndex = scanner.nextInt();

        // Kiểm tra nếu cột có hợp lệ không
        if (colIndex < 0 || colIndex >= cols) {
            System.out.println("Số thứ tự cột không hợp lệ.");
        } else {
            // Tính tổng các phần tử trong cột đã chọn
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += array[i][colIndex];
            }
            System.out.println("Tổng các phần tử trong cột " + colIndex + " là: " + sum);
        }
    }
}
