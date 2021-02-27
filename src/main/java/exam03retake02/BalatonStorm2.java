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
        List<String> result = new ArrayList<>();
        try {
            String line;
            String stationName = "";
            while ((line = reader.readLine()) != null) {
                stationName = getName(line, stationName);
                addResultByLevel(result, line, stationName);
            }
            Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }

    private void addResultByLevel(List<String> result, String line, String name) {
        int level;
        if (line.contains("level")) {
            level = Character.getNumericValue(line.split(":")[1].charAt(1));
            if (level == 3) {
                result.add(name);
            }
        }
    }

    private String getName(String line, String name) {
        if (line.contains("allomas")) {
            name = line.split(":")[1].split("\"")[1];
        }
        return name;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStorm.class.getResourceAsStream("storm.json")))) {

        System.out.println(new BalatonStorm2().getStationsInStorm(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read fil", ioe);
        }
    }
}
