public class InsertionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void insertionSort(double[] list) {
        System.out.println("Mảng ban đầu: ");
        printArray(list);

        for (int i = 1; i < list.length; i++) {
            double currentElement = list[i];
            int j;

            System.out.println("\nChèn phần tử tại index " + i + " (giá trị: " + currentElement + "):");

            // Di chuyển các phần tử lớn hơn currentElement sang bên phải
            for (j = i - 1; j >= 0 && list[j] > currentElement; j--) {
                list[j + 1] = list[j];
                System.out.println("  Di chuyển phần tử tại index " + j + " (giá trị: " + list[j] + ") sang index " + (j + 1));
                printArray(list);
            }

            // Đặt currentElement vào đúng vị trí
            list[j + 1] = currentElement;
            System.out.println("  Đặt phần tử " + currentElement + " vào vị trí index " + (j + 1));
            printArray(list);
        }
    }

    public static void printArray(double[] list) {
        for (double v : list) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println("\nMảng sau khi sắp xếp:");
        printArray(list);
    }
}
