package methodparam;

import java.util.ArrayList;
import java.util.List;

public class Measurement {

    private double[] measurements;

    public Measurement(double[] measurements) {
        this.measurements = measurements;
    }
    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] > lower && measurements[i] < upper) {
                return i;
            }
        }
        return -1;
    }
    public double minimum() {
        double minValue = measurements[0];
        for (int i = 1; i < measurements.length; i++) {
            if (measurements[i] < minValue) {
                minValue = measurements[i];
            }
        }
        return minValue;
    }
    public double maximum() {
        double maxValue = measurements[0];
        for (int i = 1; i < measurements.length; i++) {
            if (measurements[i] > maxValue) {
                maxValue = measurements[i];
            }
        }
        return maxValue;
    }
    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
