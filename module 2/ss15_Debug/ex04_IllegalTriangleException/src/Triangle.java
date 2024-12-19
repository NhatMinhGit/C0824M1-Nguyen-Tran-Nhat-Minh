// Lớp Triangle để kiểm tra và xử lý tam giác
class Triangle {
    private double side1, side2, side3;

    // Constructor
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Các cạnh của tam giác không được là số âm hoặc bằng 0.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Tổng của hai cạnh phải lớn hơn cạnh còn lại.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Phương thức in ra thông tin tam giác
    public void display() {
        System.out.println("Tam giác với các cạnh: " + side1 + ", " + side2 + ", " + side3);
    }
}