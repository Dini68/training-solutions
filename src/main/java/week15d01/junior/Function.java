package week15d01.junior;

import java.util.LinkedHashMap;
import java.util.Map;

public class Function {

    public Map<Double, Double> maxValue (Map<Double, Double> coordinates) {
        validate(coordinates);

        double maxValue = getMaxValue(coordinates);

        Map<Double, Double> maximumValues = new LinkedHashMap<>();
        for (double key: coordinates.keySet()) {
            if (coordinates.get(key) == maxValue) {
                maximumValues.put(key, maxValue);
            }
        }
        return maximumValues;
    }

    private void validate(Map<Double, Double> coordinates) {
        if (coordinates == null || coordinates.size() == 0) {
            throw new IllegalArgumentException("Not coordinate specified.");
        }
    }

    private double getMaxValue(Map<Double, Double> coordinates) {
        double maxValue = Double.MIN_VALUE;
        for (double key: coordinates.keySet()) {
            if (maxValue <= coordinates.get(key)) {
                maxValue = coordinates.get(key);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Function fu = new Function();
        Map<Double, Double> coordinates = new LinkedHashMap<>();
        coordinates.put(5.0, 8.0);
        coordinates.put(2.0, 9.0);
        coordinates.put(7.0, 2.0);
        coordinates.put(11.0, 4.0);
        coordinates.put(1.0, 9.0);
        System.out.println(fu.maxValue(coordinates));
    }
}
