package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CityFinder {

    private List<City> cities = new ArrayList<>();

    public List<City> getCities() {
        return cities;
    }

    public void skipHeader(BufferedReader br) throws IOException{
        br.readLine();
    }

    public void addCities (String[] arr) {
        if (arr.length == 2) {
            cities.add(new City(arr[0], arr[1]));
        } else {
            cities.add(new City(arr[0], arr[1], arr[2]));
        }
    }

    public String longestNamedCity (BufferedReader br) throws IOException{
        String longestNamedCity = "";
        String line;
        int maxCityNameLength = 0;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(";");
            addCities(arr);
            if (arr[1].length() >= maxCityNameLength) {
                maxCityNameLength = arr[1].length();
                longestNamedCity = arr[1];
            }
        }
        return longestNamedCity;
    }

    public String longestNamedCityFromFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            skipHeader(br);
            return longestNamedCity(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    public static void main(String[] args) {
        CityFinder cf = new CityFinder();
        System.out.println(cf.longestNamedCityFromFile("src/main/resources/iranyitoszamok-varosok.csv"));
        System.out.println(cf.getCities());
        System.out.println(cf.getCities().size());
    }
}
