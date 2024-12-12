public class arrayTest {

    // Bubble Sort with iteration counter
    public static void bubbleSort(int[] array) {
        int loop = 0; // Counter for the number of iterations
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                 // Increment loop counter for each inner loop iteration
                if (array[j] < array[j - 1]) {
                    // Swap the elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            loop++;
        }
        System.out.println("Bubble Sort - Total iterations: " + loop);
    }

    // Selection Sort with iteration counter
    public static void selectionSort(int[] array) {
        int min, loop = 0; // Index of the smallest element and loop counter
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                // Increment loop counter for each inner loop iteration
                if (array[j] < array[min]) {
                    min = j; // Record position of the smallest element
                }
            }
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            loop++;
        }
        System.out.println("Selection Sort - Total iterations: " + loop);
    }

    // Insertion Sort with iteration counter
    public static void insertionSort(int[] array) {
        int pos, x, loop = 0; // Position and loop counter
        for (int i = 1; i < array.length; i++) { // Array[0] is already sorted
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1]; // Swap elements
                pos--;
            }
            array[pos] = x;
            loop++; // Increment loop counter for each shift operation

        }
        System.out.println("Insertion Sort - Total iterations: " + loop);
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 2, 1}; // Initialize the array here

        // Call Bubble Sort and display the sorted array
        bubbleSort(array);
        System.out.print("Sorted array after Bubble Sort: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Reset the array to original values for the next sort
        array = new int[]{3, 4, 5, 2, 1};

        // Call Selection Sort and display the sorted array
        selectionSort(array);
        System.out.print("Sorted array after Selection Sort: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Reset the array to original values for the next sort
        array = new int[]{3, 4, 5, 2, 1};

        // Call Insertion Sort and display the sorted array
        insertionSort(array);
        System.out.print("Sorted array after Insertion Sort: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
