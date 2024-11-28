public class FizzBuzz {

    public String fizzBuzz(int number) {
        if (number <= 0 || number >= 100) {
            throw new IllegalArgumentException("Số phải lớn hơn 0 và nhỏ hơn 100");
        }

        String result = "";

        if (String.valueOf(number).contains("3") || number % 3 == 0) {
            result += "Fizz";
        }
        if (String.valueOf(number).contains("5") || number % 5 == 0) {
            result += "Buzz";
        }

        if (result.isEmpty()) {
            return convertNumberToWords(number);
        }

        return result;
    }

    // Chuyển số thành chữ
    private String convertNumberToWords(int number) {
        String[] words = {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        if (number < 10) {
            return words[number];
        } else {
            int tens = number / 10;
            int ones = number % 10;
            return words[tens] + " mươi" + (ones > 0 ? " " + words[ones] : "");
        }
    }
}
