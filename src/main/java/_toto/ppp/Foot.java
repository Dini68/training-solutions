package _toto.ppp;

public class Foot extends BaseLength{

    public static final double ONE_FOOT_IN_METERS = 0.3048;

    public Foot(double value) {
        this.value = value;
    }

    public Foot(Meter meter) {
        this.value = meter.getValue() / ONE_FOOT_IN_METERS;
    }

    @Override
    public Meter toMeter() {
        return new Meter(value * ONE_FOOT_IN_METERS);
    }


    @Override
    public String toString() {
        return value + " ft";
    }
}
