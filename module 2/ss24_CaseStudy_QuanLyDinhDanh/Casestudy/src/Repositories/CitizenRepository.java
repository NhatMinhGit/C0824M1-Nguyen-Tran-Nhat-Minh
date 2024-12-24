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
import java.util.Scanner;

public class CitizenRepository {
    public List<Citizens> findAll() {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATACITIZENS.csv");
        List<Citizens> citizens = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Citizens citizen;
            while ((line = bufferedReader.readLine())!= null) {
                temp = line.split(",");
                List<Citizens> parents = parseCitizensList(temp[9]); // temp[9] là chuỗi ID cha mẹ
                List<Citizens> children = parseCitizensList(temp[10]); // temp[10] là chuỗi ID con cái
                Citizens spouse = parseCitizen(temp[11]); // temp[11] là ID vợ/chồng
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
                        parents,                         // parents (nếu có thể là null hoặc danh sách rỗng)
                        children,                         // children (nếu có thể là null hoặc danh sách rỗng)
                        spouse,                         // spouse (nếu có thể là null)
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
    private List<Citizens> parseCitizensList(String data) {
        if (data == null || data.trim().isEmpty() || data.equalsIgnoreCase("null") || data.equalsIgnoreCase("None")) {
            return new ArrayList<>(); // Return empty list if no valid data
        }

        List<Citizens> citizens = new ArrayList<>();
        String[] ids = data.split(","); // Assuming IDs are separated by commas

        for (String id : ids) {
            // Ignore "None" or invalid IDs
            if (id.trim().equalsIgnoreCase("None")) {
                continue;
            }
            Citizens citizen = findCitizenById(id.trim());
            if (citizen != null) {
                citizens.add(citizen); // Add the valid citizen
            }
        }
        return citizens;
    }



    public Citizens findCitizenById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        // Get the list of all citizens
        List<Citizens> allCitizens = findAll();
        for (Citizens citizen : allCitizens) {
            // Compare IDs with trimming spaces and ensure they match
            if (citizen.getIdCard().getIdCardDigits().trim().equals(id.trim())) {
                return citizen;
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
        writeFileCitizens(citizens, false);
    }
    private Citizens parseCitizen(String id) {
        if (id == null || id.trim().isEmpty() || id.equalsIgnoreCase("null") || id.equalsIgnoreCase("None")) {
            return null; // Return null if no valid ID is provided
        }
        // Trim the ID and find the citizen
        return findCitizenById(id.trim());
    }
    public void addRelationships(String citizenId) {
        Citizens citizen = findCitizenById(citizenId);
        if (citizen == null) {
            System.out.println("Không tìm thấy công dân với ID đã nhập!");
            return;
        }

        System.out.println("Thông tin công dân: " + citizen);
        System.out.println("Chọn loại quan hệ để thêm:");
        System.out.println("1. Cha mẹ -> Con cái");
        System.out.println("2. Vợ chồng");
        System.out.print("Nhập lựa chọn của bạn: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Xóa dòng thừa sau khi nhập số

        switch (choice) {
            case 1:
                System.out.print("Nhập ID cha/mẹ: ");
                String parentId = scanner.nextLine();
                Citizens parent = findCitizenById(parentId); // Tìm công dân bằng ID
                if (parent == null) {
                    System.out.println("Không tìm thấy công dân với ID cha/mẹ đã nhập!");
                } else {
                    // Khởi tạo danh sách cha mẹ nếu chưa có
                    List<Citizens> parents = citizen.getParents();
                    if (parents == null) {
                        parents = new ArrayList<>();
                    }
                    parents.add(parent); // Thêm cha mẹ vào danh sách
                    citizen.setParents(parents); // Cập nhật danh sách cha mẹ cho công dân

                    // Nếu cần, cũng có thể thêm công dân này vào danh sách con của cha mẹ
                    List<Citizens> children = parent.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                    }
                    children.add(citizen);
                    parent.setChildren(children); // Cập nhật danh sách con cho cha mẹ

                    System.out.println("Quan hệ cha mẹ -> con cái đã được thêm.");
                }
                break;

            case 2:
                System.out.print("Nhập ID vợ/chồng: ");
                String spouseId = scanner.nextLine();
                Citizens spouse = findCitizenById(spouseId);
                if (spouse == null) {
                    System.out.println("Không tìm thấy công dân với ID vợ/chồng đã nhập!");
                } else {
                    citizen.setSpouse(spouse);
                    spouse.setSpouse(citizen); // Cập nhật vợ/chồng ở cả hai phía
                    System.out.println("Quan hệ vợ chồng đã được thêm.");
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }

        // Lưu lại các thay đổi vào danh sách công dân và file
        List<Citizens> citizens = findAll(); // Lấy lại danh sách mới nhất
        writeFileCitizens(citizens, false); // Cập nhật danh sách vào file
        System.out.println("Cập nhật danh sách vào file thành công!");
    }



    private String citizenToString(Citizens citizens) {
        return citizens.getFullName() + "," + citizens.getDob() + "," +
                citizens.getPhone() + "," + citizens.getReligion() + "," +
                citizens.getNationality() + "," + citizens.getRegisteredBornPlace() + "," +
                citizens.getOriginHomeTown() + "," + citizens.getCurrentLivePlace() + "," +
                citizens.getPermanentAddress() + "," + listToString(citizens.getParents()) + "," +
                listToString(citizens.getChildren()) + "," +
                (citizens.getSpouse() != null ? citizens.getSpouse().getIdCard().getIdCardDigits() : "None") + "," +
                citizens.getIdCard().getIdCardDigits();
    }

    private String listToString(List<Citizens> list) {
        if (list == null || list.isEmpty()) {
            return "None"; // Giá trị mặc định nếu danh sách rỗng
        }
        return list.stream()
                .map(citizen -> {
                    String id = citizen.getIdCard().getIdCardDigits();
                    return (id != null) ? id : "None";
                })
                .reduce((a, b) -> a + ";" + b) // Gộp các ID lại bằng dấu ";"
                .orElse("None");
    }



    public void writeFileCitizens(List<Citizens> citizens, boolean append) {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATACITIZENS.csv");
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
