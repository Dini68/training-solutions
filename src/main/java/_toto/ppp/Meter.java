package _toto.ppp;

public class Meter extends BaseLength{

    public Meter(Meter meter) {
        this.value = meter.value;
    }

    public Meter(double value) {
        this.value = value;
    }

    @Override
    public Meter toMeter() {
        return this;
    }

    @Override
    public String toString() {
        return value + "m";
    }
}
