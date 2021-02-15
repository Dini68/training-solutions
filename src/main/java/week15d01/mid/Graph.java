package week15d01.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph {

    private Map<Double, Double> points = new HashMap<>();

    public Graph(Map<Double, Double> points) {
        this.points = points;
    }

    public Map<Double, Double> getPoints() {
        return new HashMap<>(points);
    }

    public Map<Double, Double> maxValue () {
        if (getPoints() == null || getPoints().size() == 0) {
            throw new IllegalArgumentException("wrong list");
        }
        Map<Double, Double> result = new TreeMap<>();
        double max = 0.0;
        for (double value: getPoints().values()) {
            max = value;
        }
        for (double value: getPoints().values()) {
            if (max <= value) {
                max = value;
            }
        }
        for (double key: getPoints().keySet()) {
            if (max == getPoints().get(key)) {
                result.put(key, max);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "points=" + points +
                '}';
    }

    public static void main(String[] args) {
        Map<Double, Double> temp = new HashMap<>();
        temp.put(0.0, -5.0);
        temp.put(1.0, -3.0);
        temp.put(2.0, -4.0);
        temp.put(3.0, -3.0);
        temp.put(4.0, -10.0);
        Graph g = new Graph(temp);
        System.out.println(g.maxValue());
    }
}
// Adott egy függvénygrafikon a koordináta rendszerben.
// A grafikon néhány pontját megkapjuk egy Map-ben.
// A map kulcsa az x koordináta értéke pedig az y koordináta.
// Döntsük el, hogy a kapott pontok küzül,
// hol van a függvénynek maximum helye és ott mennyi az értéke. (edited)
