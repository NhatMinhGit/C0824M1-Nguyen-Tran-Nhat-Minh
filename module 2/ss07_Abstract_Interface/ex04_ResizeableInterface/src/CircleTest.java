public class CircleTest {
    public static void main(String[] args) {
        double percent = 1.0 + (Math.random() * (100.0 - 1.0));

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);
        circle.resize(percent);
        System.out.println(circle);
    }
}