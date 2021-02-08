package week15d01.senior;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    void maxValueTest() {
        Function fu = new Function();
        Map<Double, Double> coordinates = new LinkedHashMap<>();
        coordinates.put(5.0, 8.0);
        coordinates.put(2.0, 9.0);
        coordinates.put(7.0, 2.0);
        coordinates.put(11.0, 4.0);
        coordinates.put(1.0, 9.0);
        assertEquals(9.0, fu.maxValue(coordinates).get(2.0));
        assertEquals(9.0, fu.maxValue(coordinates).get(1.0));

    }
}