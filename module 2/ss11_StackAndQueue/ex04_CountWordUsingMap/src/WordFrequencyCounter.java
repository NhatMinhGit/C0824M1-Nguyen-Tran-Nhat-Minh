import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Nhập vào chuỗi văn bản từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào văn bản: ");
        String input = scanner.nextLine();

        // Sử dụng TreeMap để lưu trữ từ và số lần xuất hiện của từ
        Map<String, Integer> wordFrequencyMap = new TreeMap<>();

        // Xóa các ký tự đặc biệt, chuyển thành chữ thường và tách từ
        String[] words = input.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        // Duyệt từng từ trong mảng words
        for (String word : words) {
            if (wordFrequencyMap.containsKey(word)) {
                // Nếu từ đã tồn tại, tăng giá trị value (số lần xuất hiện) lên 1
                wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
            } else {
                // Nếu từ chưa tồn tại, thêm từ vào map và gán giá trị value = 1
                wordFrequencyMap.put(word, 1);
            }
        }

        // Hiển thị kết quả
        System.out.println("Số lần xuất hiện của từng từ trong văn bản (theo thứ tự bảng chữ cái):");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
