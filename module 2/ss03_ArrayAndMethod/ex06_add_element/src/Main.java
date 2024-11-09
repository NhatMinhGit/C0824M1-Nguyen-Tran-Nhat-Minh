import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước:");
            size = scanner.nextInt();
            if (size > 10)
                System.out.println("Kích thước mảng không được lớn hơn 20");
        } while (size > 10);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập giá trị thứ " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Nhập số muốn thêm: ");
        int addOne = scanner.nextInt();
        System.out.println("Nhập vị trí muốn thêm vào: ");
        int addPos = scanner.nextInt();
        for (int j = 0 ;j< array.length;j++){
            if(j == addPos-1){
                array[j] = addOne;
                for (int k = j;k<array.length-1;k++){
                    array[k+1] = array[k];

                }

                break;
            }
        }

        System.out.println(Arrays.toString(array));
    }

}