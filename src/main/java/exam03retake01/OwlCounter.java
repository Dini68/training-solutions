package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> numberOfOwlsPerCounty = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        String county;
        int numberOfOwls;
        while ((line = reader.readLine()) != null) {
            county = line.split("=")[0];
            numberOfOwls = Integer.parseInt(line.split("=")[1]);
            numberOfOwlsPerCounty.put(county, numberOfOwls);
        }
        System.out.println(numberOfOwlsPerCounty);
    }

    public int getNumberOfOwls (String county) {
        return numberOfOwlsPerCounty.get(county);
    }
}
