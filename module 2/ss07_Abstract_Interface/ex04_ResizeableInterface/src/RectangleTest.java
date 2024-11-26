public class RectangleTest {
    public static void main(String[] args) {
        double percent = 1.0 + (Math.random() * (100.0 - 1.0));
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);
        rectangle.resize(percent);
        System.out.println(rectangle);
    }
}