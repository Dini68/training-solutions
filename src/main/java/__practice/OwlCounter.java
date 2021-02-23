package __practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class OwlCounter {

    private final Map<String, Integer> numberOfOwlsByCounty = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String county = line.split("=")[0];
                int number = Integer.parseInt(line.split("=")[1]);
                numberOfOwlsByCounty.put(county, number);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public int getNumberOfOwls(String s) {
        return numberOfOwlsByCounty.get(s);
    }
}
