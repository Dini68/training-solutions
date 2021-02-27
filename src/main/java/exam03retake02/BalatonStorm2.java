package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm2 {

    public List<String> getStationsInStorm(BufferedReader reader) {
        try {
            List<String> result = getResult(reader);
            Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }

    private List<String> getResult(BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();
        String line;
        String stationName = "";
        int stormLevel = 0;
        while ((line = reader.readLine()) != null) {
            stationName = getStationName(line, stationName);
            stormLevel = getStormLevel(line, stormLevel);
            stormLevel = addStationToResultInStorm(result, stationName, stormLevel);
        }
        return result;
    }

    private int addStationToResultInStorm(List<String> result, String stationName, int stormLevel) {
        if (stormLevel == 3) {
            result.add(stationName);
            stormLevel = 0;
        }
        return stormLevel;
    }

    private String getStationName(String line, String stationName) {
        if (line.contains("allomas")) {
            stationName = line.split(":")[1].split("\"")[1];
        }
        return stationName;
    }

    private int getStormLevel(String line, int stormLevel) {
        if (line.contains("level")) {
            stormLevel = Character.getNumericValue(line.split(":")[1].charAt(1));
        }
        return stormLevel;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStorm2.class.getResourceAsStream("storm.json")))) {
            System.out.println(new BalatonStorm2().getStationsInStorm(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }
}
