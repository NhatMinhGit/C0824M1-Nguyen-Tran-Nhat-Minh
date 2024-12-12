import java.util.Stack;

public class ReverseStringWithStack {
    public static String reverseWords(String input) {
        // Khởi tạo Stack để lưu các từ
        Stack<String> wStack = new Stack<>();

        // Tách các từ trong chuỗi
        String[] words = input.split(" ");

        // Đưa từng từ vào Stack
        for (String word : words) {
            wStack.push(word);
        }

        // Lấy các từ từ Stack và nối vào chuỗi kết quả
        StringBuilder reversedString = new StringBuilder();
        while (!wStack.isEmpty()) {
            reversedString.append(wStack.pop());
            if (!wStack.isEmpty()) {
                reversedString.append(" ");
            }
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        String input = "Hello world this is Java";
        System.out.println("Chuỗi ban đầu: " + input);

        String reversed = reverseWords(input);
        System.out.println("Chuỗi sau khi đảo ngược: " + reversed);
    }
}
