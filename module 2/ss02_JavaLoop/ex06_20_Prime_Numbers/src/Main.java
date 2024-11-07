import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
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
