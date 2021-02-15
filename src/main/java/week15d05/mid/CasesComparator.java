package week15d05.mid;

import week15d04.mid.CovidNumbersPerWeek;

import java.util.Comparator;

public class CasesComparator implements Comparator<CovidNumbersPerWeek> {
    @Override
    public int compare(CovidNumbersPerWeek o1, CovidNumbersPerWeek o2) {
        return o2.getCases_Weekly() - o1.getCases_Weekly();
    }
}
