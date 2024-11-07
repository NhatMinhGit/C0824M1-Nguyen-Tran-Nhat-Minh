import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the top left triangle");
            System.out.println("3. Draw the bottom left triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    for(int i = 0;i<4;i++){
                        for(int j = 0;j<8;j++){
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Draw the top left triangle");
                    for(int i = 8;i>0;i--){
                        for(int j = 0;j<i;j++){
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Draw the bottom left triangle");
                    for(int i = 0;i<8;i++){
                        for(int j = 0;j<i;j++){
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}