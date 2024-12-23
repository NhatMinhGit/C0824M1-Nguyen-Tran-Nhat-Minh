package Repositories;

import Models.Entities.Citizens;
import Models.Entities.IdCard;
import enums.Nationality;
import enums.Region;
import enums.Religion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitizenRepository {
    public List<Citizens> findAll() {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATA.csv");
        List<Citizens> citizens = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Citizens citizen;
            while ((line = bufferedReader.readLine())!= null) {
                temp = line.split(",");
                // Giả sử mảng temp có các giá trị tương ứng
                citizen = new Citizens(
                        temp[0],                      // fullName
                        LocalDate.parse(temp[1]),     // dob
                        temp[2],                      // phone
                        Religion.valueOf(temp[3]),    // religion
                        Nationality.valueOf(temp[4]), // nationality
                        Region.valueOf(temp[5]),      // registeredBornPlace
                        Region.valueOf(temp[6]),      // originHomeTown
                        temp[7],                      // currentLivePlace
                        temp[8],                      // permanentAddress
                        null,                         // parents (nếu có thể là null hoặc danh sách rỗng)
                        null,                         // children (nếu có thể là null hoặc danh sách rỗng)
                        null,                         // spouse (nếu có thể là null)
                        new IdCard(temp[12])          // idCard (giả sử là chuỗi)
                );
                citizens.add(citizen);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return citizens;
    }

    public Citizens findById(String id) {
        List<Citizens> students = findAll();
        for (Citizens student : students) {
            if (student.getIdCard().getIdCardDigits().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public void remove(String id) {
        List<Citizens> citizens = findAll();
        for (Citizens citizen : citizens) {
            if (citizen.getIdCard().getIdCardDigits().equalsIgnoreCase(id)) {
                citizens.remove(citizen);
                break;
            }
        }
        writeFile(citizens, false);
    }
    //Đang phát triển
//    public Citizens linkParentAndChild(Citizens parent, Citizens child) {
//        List<Citizens> parents = new ArrayList<>();
//        parents.add(parent);
//        child.setParents(parents);
//        return child;
//    }
//
//    public Citizens linkSpouse(Citizens spouse1, Citizens spouse2) {
//        spouse1.setSpouse(spouse2);
//        spouse2.setSpouse(spouse1);
//        return spouse1;
//    }
    private String citizenToString(Citizens citizens) {
        return citizens.getFullName() + ","+ citizens.getDob() + ","
                + citizens.getPhone() + "," + citizens.getReligion() + ","
                + citizens.getNationality() + "," + citizens.getRegisteredBornPlace() + ","
                + citizens.getOriginHomeTown() + "," + citizens.getCurrentLivePlace() + ","
                + citizens.getPermanentAddress() + "," + citizens.getParents() + ","
                + citizens.getChildren() + "," + citizens.getSpouse() + ","
                + citizens.getIdCard().getIdCardDigits();
    }
    public void writeFile(List<Citizens> citizens, boolean append) {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATA.csv");
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Citizens citizen: citizens) {
                bufferedWriter.write(citizenToString(citizen));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
}
