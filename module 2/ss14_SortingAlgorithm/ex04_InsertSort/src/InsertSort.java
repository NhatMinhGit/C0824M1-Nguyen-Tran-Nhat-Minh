public class InsertSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void insertionSort(double[] list) {
        for (int i = 1; i < list.length; i++) {
            double currentElement = list[i];
            int j;
            // Di chuyển các phần tử lớn hơn currentElement sang bên phải
            for (j = i - 1; j >= 0 && list[j] > currentElement; j--) {
                list[j + 1] = list[j];
            }
            // Đặt currentElement vào đúng vị trí
            list[j + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (double v : list) {
            System.out.print(v + " ");
        }
    }
}
