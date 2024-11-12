public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Fan 1
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST); // Tốc độ nhanh
        fan1.setRadius(10);      // Bán kính 10
        fan1.setColor("yellow"); // Màu vàng
        fan1.setOn(true);        // Quạt bật

        // Tạo đối tượng Fan 2
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM); // Tốc độ trung bình
        fan2.setRadius(5);         // Bán kính 5
        fan2.setColor("blue");     // Màu xanh
        fan2.setOn(false);         // Quạt tắt

        // Hiển thị thông tin các đối tượng Fan
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}