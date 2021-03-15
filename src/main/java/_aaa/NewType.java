package _aaa;

public enum NewType {
    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

    private final double multiplier;

    NewType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

}
