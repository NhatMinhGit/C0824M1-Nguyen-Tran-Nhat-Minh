import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập số cần đọc
        System.out.print("Nhập số cần đọc: ");
        int number = scanner.nextInt();

        // Bước 2: Đọc số có một chữ số
        if (number >= 0 && number < 10) {
            System.out.println(readSingleDigit(number));
        }
        // Bước 3: Đọc số có hai chữ số nhỏ hơn 20
        else if (number >= 10 && number < 20) {
            System.out.println(readTeens(number));
        }
        // Bước 4: Đọc số có hai chữ số lớn hơn hoặc bằng 20
        else if (number >= 20 && number < 100) {
            System.out.println(readTwoDigits(number));
        }
        // Bước 5: Đọc số có ba chữ số
        else if (number >= 100 && number < 1000) {
            System.out.println(readThreeDigits(number));
        } else {
            System.out.println("Out of ability");
        }
    }

    // Hàm đọc số có một chữ số
    public static String readSingleDigit(int number) {
        switch (number) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "Out of ability";
        }
    }

    // Hàm đọc các số từ 10 đến 19
    public static String readTeens(int number) {
        switch (number) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "Out of ability";
        }
    }

    // Hàm đọc các số có hai chữ số từ 20 đến 99
    public static String readTwoDigits(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String result = "";

        // Đọc hàng chục
        switch (tens) {
            case 2: result = "twenty"; break;
            case 3: result = "thirty"; break;
            case 4: result = "forty"; break;
            case 5: result = "fifty"; break;
            case 6: result = "sixty"; break;
            case 7: result = "seventy"; break;
            case 8: result = "eighty"; break;
            case 9: result = "ninety"; break;
        }

        // Đọc hàng đơn vị nếu có
        if (ones != 0) {
            result += " " + readSingleDigit(ones);
        }
        return result;
    }

    // Hàm đọc các số có ba chữ số
    public static String readThreeDigits(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;
        String result = readSingleDigit(hundreds) + " hundred";

        if (remainder != 0) {
            // Thêm từ "and" giữa hàng trăm và phần còn lại nếu có phần còn lại
            result += " and " + (remainder < 10 ? readSingleDigit(remainder)
                    : remainder < 20 ? readTeens(remainder)
                    : readTwoDigits(remainder));
        }
        return result;
    }
}
