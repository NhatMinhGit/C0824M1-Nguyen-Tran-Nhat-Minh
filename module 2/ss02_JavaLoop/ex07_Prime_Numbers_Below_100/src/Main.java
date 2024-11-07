import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 100;
        System.out.println("Các số nguyên tố nhỏ hơn 100");
        for(int i = 0;i < number;i++){
            // Kiểm tra và in kết quả số nguyên tố
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }

    }

    private static boolean checkPrime(int number) {

        // Số nguyên tố là số lớn hơn hoặc bằng 2
        if (number < 2) {
            return false;
        }

        // Kiểm tra các số từ 2 đến căn bậc hai của number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
