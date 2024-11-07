import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        String currency = "";
        Scanner input = new Scanner(System.in);
        //Nhập loại tiền tệ
        System.out.println("Enter currency type: ");
        currency = input.nextLine();
        //Nhập số tiền gửi
        System.out.println("Enter investment amount: ");
        money = input.nextDouble();
        //Nhập số tháng gửi
        System.out.println("Enter number of months: ");
        month = input.nextInt();
        //Nhập lãi suất
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = input.nextDouble();
        //Tính lãi suất nhận được
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + totalInterest +" "+ currency);
    }
}