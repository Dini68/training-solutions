package week15d04;

import java.util.Comparator;

public class CovidPerWeek implements Comparable<CovidPerWeek> {

    private String week;

    private int caseNumber;

    public CovidPerWeek(String week, int caseNumber) {
        this.week = week;
        this.caseNumber = caseNumber;
    }

    public String getWeek() {
        return week;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public String toString() {
        return week + ',' + caseNumber;
    }

    @Override
    public int compareTo(CovidPerWeek o) {
        return this.getCaseNumber() - o.getCaseNumber();
    }
}
