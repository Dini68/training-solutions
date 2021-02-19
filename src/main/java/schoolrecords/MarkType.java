package schoolrecords;

public enum MarkType {

    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close fail"),
    F(1, "fail");

    private final int value;
    private final String description;

    MarkType (int value, String description) {
        this.value = value;
        this.description = description;
    }
    public static MarkType findByValue(String value) {
        return switch (value) {
            case "4" -> B;
            case "3" -> C;
            case "2" -> D;
            case "1" -> F;
            default -> A;
        };
    }
    public int getValue() {
        return value;
    }

    public String getDescription() {

        return description;
    }

}

