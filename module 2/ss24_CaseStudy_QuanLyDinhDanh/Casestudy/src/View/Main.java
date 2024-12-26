package View;

import Models.Entities.Citizens;
import Models.Entities.IdCard;
import Repositories.CitizenRepository;
import Repositories.IdCardRepository;
import enums.Nationality;
import enums.Region;
import enums.Religion;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static final CitizenRepository citizenRepository = new CitizenRepository();
    private static final IdCardRepository idCardRepository = new IdCardRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý công dân------------");
            System.out.println("1. Quản lý công dân");
            System.out.println("2. Quản lý thẻ định danh");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    menuCitizen();
                    break;
                case 2:
                    menuIdCard();
                    break;
                case 3:
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
            System.out.println("5. Thêm quan hệ cho công dân");
            System.out.println("6. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    List<Citizens> citizens = citizenRepository.findAll();
                    List<IdCard> idCards = idCardRepository.findAll();
                    Citizens citizen = inputCitizen(scanner,idCards);
                    citizens.add(citizen);
                    citizenRepository.writeFileCitizens(citizens, false);
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
                    citizen = citizenRepository.findCitizenById(id);
                    if (citizen == null) {
                        System.out.println("Không tìm thấy công dân với ID đã nhập!");
                    } else {
                        System.out.println(citizen);
                    }
                    break;
                case 5:
                    System.out.print("Cư dân cần nhập thông tin quan hệ: ");
                    id = scanner.nextLine();
                    citizen = citizenRepository.findCitizenById(id);
                    if (citizen == null) {
                        System.out.println("Không tìm thấy công dân với ID đã nhập!");
                    } else {
                        System.out.println(citizen);
                        citizenRepository.addRelationships(id);
                    }
                    break;
                case 6:
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
        System.out.println("+--------------------+----------------------+------------+----------------------+----------------------+---------------+-----------------------+-------------------+-------------------+---------------------+-------------------+-------------------+-------------------+");
    }

    public static Citizens inputCitizen(Scanner scanner, List<IdCard> idCardList) {
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
        // Kiểm tra ID công dân đã tồn tại chưa
        String id;
        boolean idExists;
        do {
            System.out.print("Nhập số ID: ");
            id = scanner.nextLine();
            idExists = isIdExist(id, idCardList);  // Kiểm tra nếu ID đã tồn tại trong danh sách
            if (!idExists) {
                System.out.println("ID này không tồn tại. Vui lòng tạo card trước khi nhập thông tin.");
                List<IdCard> idCards = idCardRepository.findAll();
                IdCard idCard = inputIdCard(scanner,idCards);
                idCards.add(idCard);
                idCardRepository.writeFileCards(idCards, false);
            }
        } while (idExists);  // Lặp lại cho đến khi ID hợp lệ


        return new Citizens(
                fullName,
                dob,
                phone,
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

            // Tìm so sánh enum và trả về enum tìm thấy
            E matchedEnum = nameToEnum.get(input);
            if (matchedEnum != null) {
                return matchedEnum;
            } else {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    //CARD
    public static void menuIdCard() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý công dân------------");
            System.out.println("1. Tạo thẻ định danh");
            System.out.println("2. Hiển thị danh sách thẻ");
            System.out.println("3. Xóa công dân");
            System.out.println("4. Tìm kiếm thẻ định danh theo mã ID");
            System.out.println("5. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    List<IdCard> idCards = idCardRepository.findAll();
                    IdCard idCard = inputIdCard(scanner,idCards);
                    idCards.add(idCard);
                    idCardRepository.writeFileCards(idCards, false);
                    System.out.println("Thêm mới thành công!");
                    break;
                case 2:
                    idCards = idCardRepository.findAll();
                    printCardsTable(idCards);
                    break;
                case 3:
                    System.out.print("Nhập ID thẻ cần xóa: ");
                    String id = scanner.nextLine();
                    idCardRepository.remove(id);
                    System.out.println("Xóa thành công!");
                    break;
                case 4:
                    System.out.print("Nhập ID thẻ cần tìm: ");
                    id = scanner.nextLine();
                    idCard = idCardRepository.findIdCardById(id);
                    if (idCard == null) {
                        System.out.println("Không tìm thấy công dân với ID đã nhập!");
                    } else {
                        System.out.println(idCard);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Người dùng nhập sai, vui lòng nhập lại");
            }
        }
    }
    public static void printCardsTable(List<IdCard> idCards) {
        System.out.println("+--------------------+----------------------+----------------------+");
        System.out.println("| ID                 |    Ngày cấp          | Ngày hết hạn         |");
        System.out.println("+--------------------+----------------------+----------------------+");
        for (IdCard idCard : idCards) {
            System.out.printf("| %-18s | %-15s | %-15s |\n",
                    idCard.getIdCardDigits(),
                    idCard.getNgayCap(),
                    idCard.getNgayHetHan());
        }
        System.out.println("+--------------------+----------------------+----------------------+");
    }
    public static IdCard inputIdCard(Scanner scanner,List<IdCard> idCardList) {
        System.out.print("Nhập mã định danh: ");
        String idCard = scanner.nextLine();
        boolean idExists;
        do {
            idExists = isIdExist(idCard, idCardList);  // Kiểm tra nếu ID đã tồn tại trong danh sách
            if (!idExists) {
                System.out.println("Nhập id không trùng. Tiếp tục nhập ngày hết hạn");
            }
        } while (idExists);  // Lặp lại cho đến khi ID hợp lệ
        System.out.print("Nhập ngày cấp (yyyy-MM-dd): ngày hiện tại");
        LocalDate createdDate = LocalDate.now();
        System.out.print("\nNhập ngày hết hạn (yyyy-MM-dd): ");
        LocalDate expiredDate = LocalDate.parse(scanner.nextLine());

        return new IdCard(
                idCard,
                createdDate,
                expiredDate
        );
    }
    // Hàm kiểm tra xem ID đã tồn tại chưa
    private static boolean isIdExist(String id, List<IdCard> idCardList) {
        for (IdCard idCard : idCardList) {
            if (idCard.getIdCardDigits().equals(id)) {
                return true; // ID đã tồn tại
            }
        }
        return false; // ID chưa tồn tại
    }
}
