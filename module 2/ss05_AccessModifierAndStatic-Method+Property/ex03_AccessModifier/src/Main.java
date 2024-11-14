public class Main {

        public static void main(String[] args) {
            Circle circle1 = new Circle(5.0, "blue");  // Creates a Circle with radius 5.0
            System.out.println("Radius of circle1: " + circle1.getRadius());
            System.out.println("Circle area :" + circle1.getArea());
            Circle circle2 = new Circle(7.5, "gray");  // Creates a default Circle
            System.out.println("Radius of circle2: " + circle2.getRadius());
            System.out.println("Circle area :" + circle2.getArea());
        }



}