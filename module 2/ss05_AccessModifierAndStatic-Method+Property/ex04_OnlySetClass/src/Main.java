public class Main {
    public static void main(String[] args) {
        Student student = new Student();  // Tạo đối tượng student

        // Gọi phương thức setName và setClasses
        student.setName("Alice");
        student.setClasses("C03");

        // Kiểm tra các giá trị đã được thiết lập
        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClasses());
    }
}
