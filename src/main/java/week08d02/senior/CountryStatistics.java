package week08d02.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    public static final String FILENAME = "countries.txt";
    public static final String SEPARATED_CHARACTER = " ";
    public static final int INDEX_OF_COUNTRY_NAME = 0;
    public static final int INDEX_OF_POPULATION = 1;
    public static final int INDEX_OF_FLAG_COLOR_NUMBER = 2;
    public static final int INDEX_OF_NEIGHBORS_NUMBER = 3;
    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public void readFromFile() {
        Path file = Path.of(FILENAME);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addCountryInLine(line);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void addCountryInLine(String line) {
        String[] parts = line.split(SEPARATED_CHARACTER);
        String name = parts[INDEX_OF_COUNTRY_NAME];
        int population = Integer.parseInt(parts[INDEX_OF_POPULATION]);
        int flagColorNumber = Integer.parseInt(parts[INDEX_OF_FLAG_COLOR_NUMBER]);
        int neighborsNumber = Integer.parseInt(parts[INDEX_OF_NEIGHBORS_NUMBER]);
        countries.add(new Country(name, population, flagColorNumber, neighborsNumber));
    }

    public Country maxPopulation() {
        Country result = null;
        int maxPopulation = 0;
        for (Country country: countries) {
            if (maxPopulation < country.getPopulation()) {
                maxPopulation = country.getPopulation();
                result = country;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountryStatistics cs = new CountryStatistics();
        cs.readFromFile();
        System.out.println(cs.maxPopulation());
    }
}
