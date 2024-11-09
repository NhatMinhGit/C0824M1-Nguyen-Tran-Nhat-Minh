import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo chuỗi
        String str = "Hello, how many times does a character appear in this string?";

        // Hiển thị chuỗi để người dùng biết
        System.out.println("Chuỗi: " + str);

        // Bước 2: Nhập ký tự cần đếm từ bàn phím
        System.out.print("Nhập ký tự cần đếm: ");
        char character = scanner.next().charAt(0);

        // Bước 3: Khai báo biến count để lưu số ký tự đếm được
        int count = 0;

        // Bước 4: Duyệt từng ký tự trong chuỗi và đếm số lần xuất hiện
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }

        // Bước 5: In ra giá trị biến count
        System.out.println("Số lần xuất hiện của ký tự '" + character + "' trong chuỗi là: " + count);
    }
}
