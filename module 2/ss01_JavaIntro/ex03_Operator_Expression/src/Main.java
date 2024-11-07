import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float width,height;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = sc.nextFloat();

        System.out.println("Enter height: ");
        height = sc.nextFloat();


        System.out.println("Area is: " + width*height);
    }

}