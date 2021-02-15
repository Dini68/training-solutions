package week15d01.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph2 {

    public Map<Double, Double> maxValueEntry(Map<Double, Double> graphOfFunction) {
        Map<Double, Double> result = new HashMap<>();
        if (graphOfFunction == null || graphOfFunction.isEmpty()) {
            throw new IllegalArgumentException("wrong list");
        }

        Map.Entry<Double, Double> maxElement = null;
        for(Map.Entry<Double, Double> actual: graphOfFunction.entrySet()) {
            if ((maxElement==null) || maxElement.getValue()<actual.getValue()) {
                maxElement = actual;
            }
        }

        for(double key: graphOfFunction.keySet()) {
            if (Math.abs(graphOfFunction.get(key) - maxElement.getValue()) < 0.00000001) {
                result.put(key, maxElement.getValue());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<Double, Double> temp = new HashMap<>();
        temp.put(0.0, -5.0);
        temp.put(1.0, -3.0);
        temp.put(2.0, -4.0);
        temp.put(3.0, -3.0);
        temp.put(-4.0, -3.0);
        Graph2 g = new Graph2();
        System.out.println(g.maxValueEntry(temp));
    }
}
// Adott egy függvénygrafikon a koordináta rendszerben.
// A grafikon néhány pontját megkapjuk egy Map-ben.
// A map kulcsa az x koordináta értéke pedig az y koordináta.
// Döntsük el, hogy a kapott pontok küzül,
// hol van a függvénynek maximum helye és ott mennyi az értéke. (edited)
