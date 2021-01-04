package week10d01;

import java.util.List;

public class Hiking {

    public double getPlusElevation(List<Double> heights) {
        double plusElevation = 0;
        for (int i = 1; i < heights.size(); i++) {
            if (heights.get(i) > heights.get(i-1) ) {
                plusElevation += heights.get(i) - heights.get(i-1);
            }
        }

        return plusElevation;
    }
}
