package enums;

public enum EthnicGroup {
    KINH("Kinh"),
    TAY("Tày"),
    THAI("Thái"),
    HOA("Hoa"),
    KHMER("Khơ me"),
    MUONG("Mường"),
    NUNG("Nùng");
    private final String name;

    EthnicGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
