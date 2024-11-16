public class Cylinder extends Circle{
    private double height = 3.0;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder() {
    }

    @Override
    public String toString() {
        return "Cylinder height: " + height
                +"\n" +super.toString() ;
    }
}
