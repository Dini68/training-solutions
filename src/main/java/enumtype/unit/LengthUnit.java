package enumtype.unit;

public enum LengthUnit {
    MILLIMETER("SI", 1.0),
    CENTIMETER("SI", 10.0),
    METER("SI", 1000.0),
    YARD("notSI", 914.4),
    FOOT("notSI", 304.8),
    INCH("notSI", 25.4);

    private final String si;

    private final double value;

    LengthUnit(String si, double value) {
        this.si = si;
        this.value = value;
    }

    public String getSi() {
        return si;
    }

    public double getValue() {
        return value;
    }
}
