public class Shape {
    private String color;
    private boolean filled;

    // Constructor không tham số
    public Shape() {
        this.color = "white";
        this.filled = false;
    }

    // Constructor có tham số
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter và Setter cho color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter và Setter cho filled
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}
