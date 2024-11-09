import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo mảng với kích thước do người dùng nhập vào
        System.out.print("Nhập kích thước của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Bước 2: Nhập giá trị cho các phần tử trong mảng từ bàn phím
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Bước 3: Giả sử phần tử đầu tiên là nhỏ nhất
        int min = array[0];

        // Bước 4: Duyệt mảng từ phần tử thứ 2 và tìm giá trị nhỏ nhất
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        // Bước 5: In ra giá trị nhỏ nhất
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
    }

}