package mvc.entity;

public class Student extends Person {
    private double point;

    public Student() {
    }

    public Student(int code, String name, String address, double point) {
        super(code, name, address);
        this.point = point;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return  String.format("| %4d | %-20s | %-20s | %6.2f |", getCode(), getName(), getAddress(), point);

    }
}