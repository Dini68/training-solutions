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
            String name = "";
            int level = 0;
            boolean foundStation = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("allomas")) {
                    name = line.split(":")[1].split("\"")[1];
//                    System.out.println(name);
                    foundStation = true;
                }
                if (line.contains("level") && foundStation) {
                    level = line.split(":")[1].charAt(1) - 48;
//                    System.out.println(level);
                    foundStation = false;
                    if (level == 3) {
                        result.add(name);
                    }
                }
            }
            Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read fil", ioe);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStorm.class.getResourceAsStream("storm.json")))) {

        System.out.println(new BalatonStorm2().getStationsInStorm(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read fil", ioe);
        }
    }
}
