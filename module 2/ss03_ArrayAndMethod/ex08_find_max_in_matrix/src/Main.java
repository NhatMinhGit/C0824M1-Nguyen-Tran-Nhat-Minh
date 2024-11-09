import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khởi tạo nhanh ma trận 2 chiều
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Gọi hàm tìm phần tử lớn nhất với ma trận khởi tạo sẵn
        findMax(matrix);

        // Bước 2: Nhập liệu từ người dùng để tạo ma trận
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();

        double[][] userMatrix = new double[rows][cols];

        // Nhập giá trị cho ma trận từ người dùng
        System.out.println("Nhập các phần tử cho ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                userMatrix[i][j] = scanner.nextDouble();
            }
        }

        // Gọi hàm tìm phần tử lớn nhất với ma trận nhập từ người dùng
        findMax(userMatrix);
    }

    // Hàm tìm phần tử lớn nhất trong ma trận và in ra tọa độ và giá trị
    public static void findMax(double[][] matrix) {
        double max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        // Duyệt qua các phần tử để tìm phần tử lớn nhất
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // In ra kết quả
        System.out.println("Phần tử lớn nhất là " + max + " tại tọa độ [" + maxRow + "][" + maxCol + "]");
    }
}