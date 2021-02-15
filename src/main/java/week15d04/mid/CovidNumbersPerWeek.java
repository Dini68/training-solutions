package week15d04.mid;

public class CovidNumbersPerWeek {

    private String country;

    private String year_Week;

    private int cases_Weekly;

    private int death_Weekly;

    private int population;


    public CovidNumbersPerWeek(String country, String year_Week, int cases_Weekly, int death_Weekly, int population) {
        this.country = country;
        this.year_Week = year_Week;
        this.cases_Weekly = cases_Weekly;
        this.death_Weekly = death_Weekly;
        this.population = population;
    }


    public String getYear_Week() {
        return year_Week;
    }

    public int getCases_Weekly() {
        return cases_Weekly;
    }

    public int getDeath_Weekly() {
        return death_Weekly;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return  country + '\'' +
                ", year_Week='" + year_Week + '\'' +
                ", cases_Weekly=" + cases_Weekly +
                ", death_Weekly=" + death_Weekly +
                ", population=" + population + "\n";
    }
}
