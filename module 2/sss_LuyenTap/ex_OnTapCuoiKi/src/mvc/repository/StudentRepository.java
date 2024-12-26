package mvc.repository;

import mvc.entity.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public static final String STUDENT_CSV = "src/mvc/data/student.csv";


    public List<Student> findAll() {
        File file = new File(STUDENT_CSV);
        List<Student> students = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Student student;
            while ((line = bufferedReader.readLine())!= null) {
                temp = line.split(",");
                student = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], Double.parseDouble(temp[3]));
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return students;
    }

    public List<Student> findAllByName(String name) {
        List<Student> result = new ArrayList<>();
        List<Student> students = findAll();
        for (Student student : students) {
//            Tìm kiếm gần đúng
            if (student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public void save(Student student) {
        List<Student> students = new ArrayList<>();
        students.add(student);
        writeFile(students, true);
//        File file = new File("src/mvc/data/student.dat");
//        try {
//            OutputStream outputStream = new FileOutputStream(file);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//            List<Student> students = findAll();
//            students.add(student);
//            objectOutputStream.writeObject(students);
//        } catch (IOException e) {
//            System.out.println("Lỗi dọc file");
//        }

    }

    //Chuyển đổi thuộc tính thành String trước khi ghi vào file
    private String studentToString(Student student) {
        return student.getCode() + "," + student.getName() + "," + student.getAddress() + "," + student.getPoint();
    }

    public Student findById(int id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getCode() == id) {
                return student;
            }
        }
        return null;
    }

    public void remove(int id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getCode() == id) {
                students.remove(student);
                break;
            }
        }
        writeFile(students, false);
    }

    public void writeFile(List<Student> students, boolean append) {
        File file = new File(STUDENT_CSV);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Student student: students) {
                bufferedWriter.write(studentToString(student));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
}