import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int size;
        int[] arr;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = sc.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            i++;
        }

        for(int j = 0; j < arr.length /2; j++){
            int temp = arr[j];
            arr[j] = arr[size-j-1];
            arr[size-j-1] = temp;
        }
        for(int j = 0; j < arr.length ; j++){
            System.out.print(arr[j] + "\t");
        }
    }
}