import java.util.Stack;

public class ReverseArrayWithStack {
    public static void reverseArray(int[] array) {
        // Khởi tạo một Stack rỗng
        Stack<Integer> stack = new Stack<>();

        // Đưa các phần tử của mảng vào Stack
        for (int value : array) {
            stack.push(value);
        }

        // Lấy các phần tử ra khỏi Stack và đưa lại vào mảng
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Mảng ban đầu: ");
        for (int value : array) {
            System.out.print(value + " ");
        }

        reverseArray(array);

        System.out.println("\nMảng sau khi đảo ngược: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
