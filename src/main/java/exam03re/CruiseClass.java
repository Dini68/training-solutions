package exam03re;

public enum CruiseClass {

    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

        private double multiple;

    public double getMultiple() {
        return multiple;
    }

    CruiseClass(double multiple) {
        this.multiple = multiple;
    }
}
