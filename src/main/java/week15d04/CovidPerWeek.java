package week15d04;

import java.util.Comparator;

public class CovidPerWeek implements Comparable<CovidPerWeek> {

    private String week;

    private int caseNumber;

    private String country;

    public CovidPerWeek(String week, int caseNumber, String country) {
        this.week = week;
        this.caseNumber = caseNumber;
        this.country = country;
    }

    public String getWeek() {
        return week;
    }

    public int getCaseNumber() {
        return caseNumber;
    }


    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "\n" + week + " " + caseNumber + " " + country;
    }

    @Override
    public int compareTo(CovidPerWeek o) {
        return this.getCaseNumber() - o.getCaseNumber();
    }
}
