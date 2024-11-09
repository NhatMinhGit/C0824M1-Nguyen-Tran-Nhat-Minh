import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Tạo 2 mảng với kích thước cho trước
        System.out.print("Nhập kích thước mảng 1: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];

        System.out.print("Nhập kích thước mảng 2: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        // Bước 2: Nhập giá trị cho các phần tử trong 2 mảng
        System.out.println("Nhập các phần tử cho mảng 1:");
        for (int i = 0; i < size1; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }

        System.out.println("Nhập các phần tử cho mảng 2:");
        for (int i = 0; i < size2; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }

        // Bước 3: Tạo mảng thứ 3 có kích thước bằng kích thước mảng 1 + kích thước mảng 2
        int[] mergedArray = new int[size1 + size2];

        // Bước 4: Gán phần tử của mảng 1 vào mảng thứ 3
        for (int i = 0; i < size1; i++) {
            mergedArray[i] = array1[i];
        }

        // Bước 5: Gán phần tử của mảng 2 vào mảng thứ 3
        for (int i = 0; i < size2; i++) {
            mergedArray[size1 + i] = array2[i];
        }

        // In mảng sau khi gộp
        System.out.println("Mảng sau khi gộp:");
        for (int element : mergedArray) {
            System.out.print(element + " ");
        }
    }
}