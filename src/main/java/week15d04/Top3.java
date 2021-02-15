package week15d04;

import java.util.ArrayList;
import java.util.List;

public class Top3 implements Comparable<Top3>{

    private int maxCovidNumber;

    List<String> top3List = new ArrayList<>();

    public Top3(int maxCovidNumber, List<String> top3List) {
        this.maxCovidNumber = maxCovidNumber;
        this.top3List = top3List;
    }

    public int getMaxCovidNumber() {
        return maxCovidNumber;
    }

    public List<String> getTop3List() {
        return top3List;
    }

    @Override
    public String toString() {
        return maxCovidNumber + " " +  top3List;
    }

    @Override
    public int compareTo(Top3 o) {
        return this.maxCovidNumber - o.maxCovidNumber;
    }
}
