package enums;

public enum Religion {
    PHAT("Phật"),
    CHUA("Chúa");
    private final String name;

    Religion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
