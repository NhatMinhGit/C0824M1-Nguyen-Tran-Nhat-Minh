package enums;

public enum Region {
    HA_NOI("01", "Hà Nội", "Thành phố", "Đồng bằng sông Hồng"),
    HAI_PHONG("02", "Hải Phòng", "Thành phố", "Đồng bằng sông Hồng"),
    QUANG_NINH("22", "Quảng Ninh", "Tỉnh", "Đông Bắc Bộ"),
    HO_CHI_MINH("79", "Hồ Chí Minh","Thành phố"," Đông Nam Bộ"),
    QUANG_NGAI("51","Quảng Ngãi","Tỉnh","Nam Trung Bộ"),
    DA_NANG("48","Đà Nẵng","Thành phố","Nam Trung Bộ");


    private final String code;
    private final String name;
    private final String type;
    private final String area;

    Region(String code, String name, String type, String area) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.area = area;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getArea() {
        return area;
    }
}
