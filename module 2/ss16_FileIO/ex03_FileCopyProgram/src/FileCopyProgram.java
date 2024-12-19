import java.io.*;
import java.util.Scanner;

public class FileCopyProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đường dẫn tập tin nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.println("Nhập đường dẫn tập tin đích: ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // Kiểm tra nếu tập tin nguồn không tồn tại
        if (!sourceFile.exists()) {
            System.err.println("Lỗi: Tập tin nguồn không tồn tại.");
            return;
        }

        // Kiểm tra nếu tập tin đích đã tồn tại
        if (targetFile.exists()) {
            System.err.println("Cảnh báo: Tập tin đích đã tồn tại. Chương trình sẽ không ghi đè.");
            return;
        }

        // Sao chép tập tin và tính số ký tự
        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(targetFile)) {

            int character;
            int charCount = 0;

            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
                charCount++;
            }

            System.out.println("Sao chép tập tin thành công!");
            System.out.println("Tổng số ký tự đã sao chép: " + charCount);

        } catch (IOException e) {
            System.err.println("Lỗi trong quá trình sao chép tập tin: " + e.getMessage());
        }
    }
}
