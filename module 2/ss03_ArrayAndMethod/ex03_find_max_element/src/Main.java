import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Kích thước mảng không được lớn hơn 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập giá trị thứ " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        int max = array[0];
        for(int j = 0; j< array.length ; j++){
            if(max < array[j]){
                max = array[j];
            }
        }
        System.out.println("Số lớn nhất trong mảng là " + max);
    }
}