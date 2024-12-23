package enums;

public enum Nationality {
    VIETNAM("VN", "Việt Nam"),
    UNITED_STATES("US", "Mỹ"),
    JAPAN("JP", "Nhật Bản"),
    SOUTH_KOREA("KR", "Hàn Quốc"),
    CHINA("CN", "Trung Quốc"),
    GERMANY("DE", "Đức"),
    FRANCE("FR", "Pháp"),
    UNITED_KINGDOM("UK", "Anh"),
    CANADA("CA", "Canada"),
    AUSTRALIA("AU", "Úc"),
    INDIA("IN", "Ấn Độ");

    private final String code;
    private final String name;

    Nationality(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
