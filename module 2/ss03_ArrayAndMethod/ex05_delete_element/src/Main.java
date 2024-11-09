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
        System.out.println("Nhập số muốn xóa: ");
        int deleteOne = scanner.nextInt();
        boolean found=false;
        for (int j = 0 ;j< array.length;j++){
            if(array[j] == deleteOne){
                for (int k = j;k<array.length-1;k++){
                    array[k] = array[k+1];
                    if(k == array.length-1){
                        array[k] = 0;
                    }
                }
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy số muốn xóa");
        }
        System.out.println(Arrays.toString(array));
    }

}