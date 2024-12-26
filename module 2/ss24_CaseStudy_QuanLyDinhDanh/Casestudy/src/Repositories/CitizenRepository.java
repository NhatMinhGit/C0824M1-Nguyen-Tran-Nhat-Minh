package Repositories;

import Models.Entities.Citizens;
import Models.Entities.IdCard;
import enums.Nationality;
import enums.Region;
import enums.Religion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CitizenRepository {
    private List<Citizens> parseCitizensList(String data, List<Citizens> allCitizens) {
        // Ensure the data is valid
        if (data == null || data.trim().isEmpty() || data.equalsIgnoreCase("null") || data.equalsIgnoreCase("Null")) {
            return new ArrayList<>(); // Return an empty list if no valid data
        }

        List<Citizens> citizens = new ArrayList<>();

        // Declare and initialize 'ids' inside the method
        String[] ids = data.split(";");

        // Iterate through the ids
        for (String id : ids) {
            id = id.trim(); // Trim spaces from the id
            if (id.equalsIgnoreCase("Null") || id.isEmpty()) {
                continue; // Skip invalid ids
            }

            // Find the citizen by id
            Citizens citizen = findCitizenById(id, allCitizens);
            if (citizen != null) {
                citizens.add(citizen);
            } else {
                System.out.println("Could not find citizen with ID: " + id); // Debugging line
            }
        }
        return citizens;
    }



    private Citizens findCitizenById(String id, List<Citizens> allCitizens) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Citizens citizen : allCitizens) {
            // Compare IDs with trimming spaces and ensure they match
            if (citizen.getIdCard().getIdCardDigits().trim().equals(id.trim())) {
                return citizen;
            }
        }
        return null;
    }

    public List<Citizens> findAll() {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATACITIZENS.csv");
        List<Citizens> citizens = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Citizens citizen;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");

                // Xử lý "Null" trong các trường cha mẹ và con cái
                System.out.println("Parents data: " + temp[9]);
                List<Citizens> parents = parseCitizensList(temp[9].equals("Null") ? "" : temp[9], citizens);
                List<Citizens> children = parseCitizensList(temp[10].equals("Null") ? "" : temp[10], citizens);
                Citizens spouse = temp[11].equals("Null") ? null : findCitizenById(temp[11].trim(), citizens);

                // Tạo công dân từ thông tin đọc được
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
                        parents,                      // parents
                        children,                     // children
                        spouse,                       // spouse
                        new IdCard(temp[12])          // idCard
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
        List<Citizens> citizens = findAll(); // Lấy lại danh sách mới nhất chưa đưa vào
        switch (choice) {
            case 1:
                System.out.print("Nhập ID cha/mẹ: ");
                String parentId = scanner.nextLine();

                // Tìm công dân bằng ID cha/mẹ
                Citizens parent = findCitizenById(parentId);
                if (parent == null) {
                    System.out.println("Không tìm thấy công dân với ID cha/mẹ đã nhập!");
                } else {
                    // Khởi tạo danh sách cha mẹ cho citizen nếu chưa có
                    List<Citizens> parents = citizen.getParents();
                    if (parents == null) {
                        parents = new ArrayList<>();
                    }

                    // Kiểm tra xem parent đã tồn tại trong danh sách cha mẹ chưa
                    if (!parents.contains(parent)) {
                        parents.add(parent); // Thêm cha/mẹ vào danh sách cha mẹ
                        citizen.setParents(parents); // Cập nhật danh sách cha mẹ cho citizen
                    }

                    // Khởi tạo danh sách con cho parent nếu chưa có
                    List<Citizens> children = parent.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                    }

                    // Kiểm tra xem citizen đã tồn tại trong danh sách con của parent chưa
                    if (!children.contains(citizen)) {
                        children.add(citizen); // Thêm công dân vào danh sách con
                        parent.setChildren(children); // Cập nhật danh sách con cho parent
                    }
                    updateParentsAndChildrenCitizens(citizen,citizens);
                    System.out.println("Quan hệ cha mẹ -> con cái đã được thêm thành công.");
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
                    updateSpouseCitizens(citizen,citizens);
                    System.out.println("Quan hệ vợ chồng đã được thêm.");
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }

        // Lưu lại các thay đổi vào danh sách công dân và file
        writeFileCitizens(citizens, false); // Cập nhật danh sách vào file
        System.out.println("Cập nhật danh sách vào file thành công!");
    }

    public boolean updateSpouseCitizens(Citizens ctzNewInfor,List<Citizens> list) {

        Citizens temp = list
                .stream()
                .filter(bn -> bn.getIdCard().getIdCardDigits().equalsIgnoreCase(ctzNewInfor.getIdCard().getIdCardDigits()))
                .findFirst()
                .orElse(null);

        if(temp == null)
            return false;

        temp.setSpouse(ctzNewInfor.getSpouse());
        return true;
    }
    public boolean updateParentsAndChildrenCitizens(Citizens ctzNewInfor,List<Citizens> list) {

        Citizens temp = list
                .stream()
                .filter(bn -> bn.getIdCard().getIdCardDigits().equalsIgnoreCase(ctzNewInfor.getIdCard().getIdCardDigits()))
                .findFirst()
                .orElse(null);

        if(temp == null)
            return false;

        temp.setParents(ctzNewInfor.getParents());
        temp.setChildren(ctzNewInfor.getChildren());
        return true;
    }
    private String citizenToString(Citizens citizens) {
        return citizens.getFullName() + "," + citizens.getDob() + "," +
                citizens.getPhone() + "," + citizens.getReligion() + "," +
                citizens.getNationality() + "," + citizens.getRegisteredBornPlace() + "," +
                citizens.getOriginHomeTown() + "," + citizens.getCurrentLivePlace() + "," +
                citizens.getPermanentAddress() + "," + listToString(citizens.getParents()) + "," +
                listToString(citizens.getChildren()) + "," +
                (citizens.getSpouse() != null ? citizens.getSpouse().getIdCard().getIdCardDigits() : "Null") + "," +
                citizens.getIdCard().getIdCardDigits();
    }

    private String listToString(List<Citizens> list) {
        if (list == null || list.isEmpty()) {
            return "Null"; // Giá trị mặc định nếu danh sách rỗng
        }
        return list.stream()
                .map(citizen -> {
                    String id = citizen.getIdCard().getIdCardDigits();
                    return (id != null) ? id : "Null";
                })
                .reduce((a, b) -> a + ";" + b) // Gộp các ID lại bằng dấu ";"
                .orElse("Null");
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
