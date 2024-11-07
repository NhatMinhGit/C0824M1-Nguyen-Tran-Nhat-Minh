import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double tiGia = 23000;
        System.out.println("Nhập giá trị USD: ");
        double usd = sc.nextDouble();
        System.out.println("Giá trị quy đổi ra VND: "+ usd*tiGia);
    }
}