package View;

import Models.Entities.Citizens;
import Models.Entities.IdCard;
import Repositories.CitizenRepository;
import enums.Nationality;
import enums.Region;
import enums.Religion;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static final CitizenRepository citizenRepository = new CitizenRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý công dân------------");
            System.out.println("1. Quản lý công dân");
            System.out.println("2. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    menuCitizen();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Người dùng nhập sai, vui lòng nhập lại");
            }
        }
    }

    public static void menuCitizen() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý công dân------------");
            System.out.println("1. Thêm công dân");
            System.out.println("2. Hiển thị danh sách công dân");
            System.out.println("3. Xóa công dân");
            System.out.println("4. Tìm kiếm công dân theo mã ID");
            System.out.println("5. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    Citizens citizen = inputCitizen(scanner);
                    List<Citizens> citizens = citizenRepository.findAll();
                    citizens.add(citizen);
                    citizenRepository.writeFile(citizens, false);
                    System.out.println("Thêm mới thành công!");
                    break;
                case 2:
                    citizens = citizenRepository.findAll();
                    printCitizensTable(citizens);
                    break;
                case 3:
                    System.out.print("Nhập ID công dân cần xóa: ");
                    String id = scanner.nextLine();
                    citizenRepository.remove(id);
                    System.out.println("Xóa thành công!");
                    break;
                case 4:
                    System.out.print("Nhập ID cần tìm: ");
                    id = scanner.nextLine();
                    citizen = citizenRepository.findById(id);
                    if (citizen == null) {
                        System.out.println("Không tìm thấy công dân với ID đã nhập!");
                    } else {
                        System.out.println(citizen);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Người dùng nhập sai, vui lòng nhập lại");
            }
        }
    }

    public static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi! Vui lòng nhập số nguyên.");
            }
        }
    }

    public static void printCitizensTable(List<Citizens> citizens) {
        System.out.println("+--------------------+----------------------+------------+----------------------+----------------------+---------------+-----------------------+-------------------+-------------------+---------------------+-------------------+-------------------+-------------------+");
        System.out.println("| ID                 | Full Name            | DOB        | Phone                | Religion             | Nationality   | Registered Born Place | Origin HomeTown   | Current Address   | Permanent Address   | Parents           | Children          | Spouse            |");
        System.out.println("+--------------------+----------------------+------------+----------------------+----------------------+---------------+-----------------------+-------------------+-------------------+---------------------+-------------------+-------------------+-------------------+");
        for (Citizens citizen : citizens) {
            System.out.printf("| %-18s | %-20s | %-10s | %-20s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s | %-17s |\n",
                    citizen.getIdCard().getIdCardDigits(),
                    citizen.getFullName(),
                    citizen.getDob(),
                    citizen.getPhone(),
                    citizen.getReligion(),
                    citizen.getNationality(),
                    citizen.getRegisteredBornPlace(),
                    citizen.getOriginHomeTown(),
                    citizen.getCurrentLivePlace(),
                    citizen.getPermanentAddress(),
                    citizen.getParents(),
                    citizen.getChildren(),
                    citizen.getSpouse());
        }
        System.out.println("+------+----------------------+------------+-------------------+");
    }

    public static Citizens inputCitizen(Scanner scanner) {
        System.out.print("Nhập tên đầy đủ: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhập tôn giáo: ");
        Religion religion = inputEnum(scanner, Religion.class, "tôn giáo");
        System.out.print("Nhập quốc tịch: ");
        Nationality nationality = inputEnum(scanner, Nationality.class, "quốc tịch");
        System.out.print("Nhập nơi đăng ký khai sinh: ");
        Region registeredBornPlace = inputEnum(scanner, Region.class, "nơi đk khai sinh");
        System.out.print("Nhập quê quán: ");
        Region originHomeTown = inputEnum(scanner, Region.class, "quê quán");
        System.out.print("Nhập địa chỉ hiện tại: ");
        String currentAddress = scanner.nextLine();
        System.out.print("Nhập địa chỉ thường trú: ");
        String permanentAddress = scanner.nextLine();
        System.out.print("Nhập số ID: ");
        String id = scanner.nextLine();

        // For simplicity, set default values for enum fields
        return new Citizens(
                fullName,
                dob,
                phone,  // Placeholder for phone
                religion,
                nationality,
                registeredBornPlace,
                originHomeTown,
                currentAddress,
                permanentAddress,
                null,  // Placeholder for parents
                null,  // Placeholder for children
                null,  // Placeholder for spouse
                new IdCard(id)
        );
    }
    public static <E extends Enum<E>> E inputEnum(Scanner scanner, Class<E> enumClass, String displayName) {
        while (true) {
            System.out.println("Danh sách " + displayName + " hợp lệ:");

            // Map display names to enum constants
            Map<String, E> nameToEnum = new HashMap<>();
            for (E constant : enumClass.getEnumConstants()) {
                if (constant instanceof Religion) {
                    nameToEnum.put(((Religion) constant).getName().toLowerCase(), constant);
                    System.out.println("- " + ((Religion) constant).getName());
                } else {
                    nameToEnum.put(constant.name().toLowerCase(), constant);
                    System.out.println("- " + constant.name());
                }
            }

            System.out.print("Nhập " + displayName + ": ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Try to find the matching enum constant
            E matchedEnum = nameToEnum.get(input);
            if (matchedEnum != null) {
                return matchedEnum;
            } else {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

}
