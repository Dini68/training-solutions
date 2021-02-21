package week06d03.senior;

import java.util.ArrayList;
import java.util.List;

public class Series {

    public SeriesType calculateSeriesType (List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("invalid list");
        }
        SeriesType result = null;

        for (int i = 0; i < numbers. size() - 1; i++) {
            if (numbers.get(i + 1) == numbers.get(i)) {
                throw new IllegalArgumentException("the next number cannot be same.");
            }
            if (numbers.get(i + 1) > numbers.get(i) && result != SeriesType.DECREASING) {
                result = SeriesType.INCREASING;
            }
            if (numbers.get(i + 1) < numbers.get(i) && result != SeriesType.INCREASING) {
                result = SeriesType.DECREASING;
            }
            if (result == SeriesType.INCREASING && numbers.get(i + 1) < numbers.get(i) ||
                result == SeriesType.DECREASING && numbers.get(i + 1) > numbers.get(i)) {
                return SeriesType.FLUCTUATION;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Series().calculateSeriesType(new ArrayList<>(List.of(1, 4, 5, 7, 8, 11, 56))));
        System.out.println(new Series().calculateSeriesType(new ArrayList<>(List.of(1, 4, 7, 5, 11, 56))));
        System.out.println(new Series().calculateSeriesType(new ArrayList<>(List.of(21, 14, 7, 5, 1, -6))));
        System.out.println(new Series().calculateSeriesType(new ArrayList<>(List.of(21,21))));
    }
}
