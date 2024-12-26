package mvc.view;

import mvc.controller.StudentController;
import mvc.entity.Student;

import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý CodeGym------------");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý giáo viên");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Người dùng nhập sai, vui lòng nhập lại");
            }
        }
    }

    public static void menuStudent() {
        StudentController studentController = new StudentController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý học sinh------------");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm kiếm học sinh theo tên");
            System.out.println("6. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            List<Student> students;
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    Student student = inputStudent(scanner);
                    studentController.save(student);
                    System.out.println("Thêm mới thành công!!!!!!");
                    break;
                case 2:
                    students = studentController.getAll();
                    printStudentsTable(students);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print("Nhập vào mã học sinh cần xóa: ");
                    int code = Integer.parseInt(scanner.nextLine());
                    student = studentController.findById(code);
                    if(student == null) {
                        System.out.println("Không tìm thấy đối tượng cần xóa");
                    } else {
                        System.out.println("Thông tin của học sinh: "+ student);
                        System.out.println("bạn có chắc muốn xóa hay không? Nếu có thì bấm Y, nếu không thì bấm N");
                        char confirm = scanner.nextLine().charAt(0);
                        if(confirm == 'y') {
                            studentController.remove(code);
                            System.out.println("Xóa thành công");
                        }
                    }
                    break;
                case 5:

                    System.out.print("Nhập vào tên cần tìm: ");
                    String name = scanner.nextLine();
                    students = studentController.findAllByName(name);
                    printStudentsTable(students);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Người dùng nhập sai, vui lòng nhập lại");
            }
        }

    }

    public static int getChoice(Scanner scanner) throws NumberFormatException {
//        int choice;
//        while(true) {
//            try {
//                choice = Integer.parseInt(scanner.nextLine());
//                break;
//            }catch (NumberFormatException e) {
//                System.out.println("Người dùng nhập không đúng, vui lòng nhập lại");
//            } catch (Exception e) {
//                System.out.println("Lỗi không xác định");
//            } finally {
////                 Finally được thực hiện cuối cùng
//            }
//        }
        int choice  = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > 10000000) {
            throw new NumberFormatException("Lỗi nhập choice");
        }
        return choice;
    }

    public static void printStudentsTable(List<Student> students) {
        System.out.println("+------+----------------------+----------------------+--------+");
        System.out.println("| Code | Name                 | Address              | Point  |");
        System.out.println("+------+----------------------+----------------------+--------+");
        for (Student temp : students) {
            System.out.println(temp);
        }
        System.out.println("+------+----------------------+----------------------+--------+");
    }

    public static Student inputStudent(Scanner scanner) {
        System.out.print("Nhập mã học sinh:");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên học sinh:");
        String name = scanner.nextLine();
        String regex = "^[A-Z]{1}[a-z ]+$";
        while(!name.trim().matches(regex)) {
            System.out.println("Tên không đúng định dạng");
            System.out.print("Nhập lại tên học sinh:");
            name = scanner.nextLine();
        }
        System.out.print("Nhập địa chỉ học sinh:");
        String address = scanner.nextLine();
        System.out.print("Nhập điểm học sinh:");
        double point = Double.parseDouble(scanner.nextLine());
        Student student = new Student(code,name, address, point);
        return student;
    }
}