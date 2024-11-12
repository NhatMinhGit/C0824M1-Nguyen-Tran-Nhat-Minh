import java.util.Random;

public class Main {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap elements
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Tạo mảng với 100,000 số ngẫu nhiên
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000000);  // Số ngẫu nhiên từ 0 đến 999,999
        }

        // Khởi tạo Stopwatch và bắt đầu đếm giờ
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        // Sắp xếp mảng bằng thuật toán Selection Sort
        selectionSort(array);

        // Dừng đồng hồ và tính thời gian đã trôi qua
        stopwatch.stop();

        // Hiển thị thời gian đã trôi qua
        System.out.println("Time taken for Selection Sort on 100,000 numbers: "
                + stopwatch.getElapsedTime() + " milliseconds.");
    }
}