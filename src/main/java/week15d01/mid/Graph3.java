package week15d01.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph3 {

    public Map<Double, Double> maxValue(Map<Double, Double> graphOfFunction) {
        Map<Double, Double> result = new TreeMap<>();
        if (graphOfFunction == null || graphOfFunction.isEmpty()) {
            throw new IllegalArgumentException("wrong list");
        }

        Double max = null;
        for(double key: graphOfFunction.keySet()) {
            if ((max == null) || max < graphOfFunction.get(key)) {
                max = graphOfFunction.get(key);
            }
        }

        for(double key: graphOfFunction.keySet()) {
            if (Math.abs(graphOfFunction.get(key) - max) < 0.000000001) {
                result.put(key, max);
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
        Graph3 g = new Graph3();
        System.out.println(g.maxValue(temp));
    }
}
// Adott egy függvénygrafikon a koordináta rendszerben.
// A grafikon néhány pontját megkapjuk egy Map-ben.
// A map kulcsa az x koordináta értéke pedig az y koordináta.
// Döntsük el, hogy a kapott pontok küzül,
// hol van a függvénynek maximum helye és ott mennyi az értéke. (edited)
