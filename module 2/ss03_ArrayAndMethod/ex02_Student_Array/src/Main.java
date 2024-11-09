import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên bạn muốn tìm : ");
        String name = sc.nextLine();
        boolean found=false;
        
        for(int i = 0; i < array.length ; i++){
            if(array[i].equalsIgnoreCase(name)){
                System.out.println("Sinh viên "+ name + " có trong danh sách");
                System.out.println("Vị trí trong danh sách là : "+ i);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy");
        }
    }
}