package schoolrecords;

import java.util.Scanner;

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
        switch (value){
            case "5":
                return A;
            case "4":
                return B;
            case "3":
                return C;
            case "2":
                return D;
            case "1":
                return F;
            default:
                    return A;
        }
    }
    public int getValue() {
        return value;
    }

    public String getDescription() {

        return description;
    }

}

