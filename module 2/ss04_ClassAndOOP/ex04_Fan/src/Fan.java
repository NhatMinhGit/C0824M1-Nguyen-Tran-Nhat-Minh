public class Fan {

    // Các hằng số cho tốc độ
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Các trường dữ liệu
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";

    // Phương thức khởi tạo không tham số (các giá trị mặc định)
    public Fan() {
    }

    // Getter và Setter cho các thuộc tính
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Phương thức toString trả về thông tin của quạt
    public String toString() {
        if (on) {
            return "Fan is on with speed " + speed + ", color " + color + ", and radius " + radius;
        } else {
            return "Fan is off with color " + color + " and radius " + radius;
        }
    }
}