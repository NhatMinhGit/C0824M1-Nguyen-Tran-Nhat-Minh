import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 2: Thu thập kích thước của ma trận từ người dùng
        System.out.print("Nhập kích thước của ma trận vuông: ");
        int size = scanner.nextInt();

        // Khởi tạo ma trận vuông
        double[][] matrix = new double[size][size];

        // Nhập các giá trị cho ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Tính tổng các phần tử trên đường chéo chính
        double sumDiagonal = 0;
        for (int i = 0; i < size; i++) {
            sumDiagonal += matrix[i][i];
        }

        // In kết quả
        System.out.println("Tổng các phần tử trên đường chéo chính là: " + sumDiagonal);
    }
}
