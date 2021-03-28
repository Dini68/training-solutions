package week10d01.senior;

public class ElevationDate {

    private double increase;
    private double decrease;

    public double getDecrease() {
        return decrease;
    }

    public double getIncrease() {
        return increase;
    }

    public void addIncrease(double value) {
        increase += value;
    }
    public void addDecrease(double value) {
        decrease += value;
    }

    @Override
    public String toString() {
        return "ElevationDate{" +
                "increase=" + increase +
                ", decrease=" + decrease +
                '}';
    }
}
