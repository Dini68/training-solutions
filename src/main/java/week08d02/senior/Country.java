package week08d02.senior;

public class Country {

    private String name;
    private int population;
    private int numberOfFlagColor;
    private int numberOfNeighboringCountries;

    public Country(String name, int population, int numberOfFlagColor, int numberOfNeighboringCountries) {
        this.name = name;
        this.population = population;
        this.numberOfFlagColor = numberOfFlagColor;
        this.numberOfNeighboringCountries = numberOfNeighboringCountries;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getNumberOfFlagColor() {
        return numberOfFlagColor;
    }

    public int getNumberOfNeighboringCountries() {
        return numberOfNeighboringCountries;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", numberOfFlagColor=" + numberOfFlagColor +
                ", numberOfNeighboringCountries=" + numberOfNeighboringCountries +
                '}';
    }
}
