package exam0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();
        String line;
        String name = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("allomas")) {
                name = line.split(":")[1];
                name = name.substring(2, name.indexOf(",")-1);
            }
            if (line.contains("level")) {
                String level = line.split(":")[1] ;
                if (level.charAt(1) == '3') {
                    result.add(name);
                }
            }
        }
        //Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
        result.sort(Collator.getInstance(new Locale("hu", "HU")));

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        BalatonStorm balatonStorm = new BalatonStorm();
        BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStorm.class.getResourceAsStream("storm.json")));
        try {
            balatonStorm.getStationsInStorm(reader);
        } catch (IOException ioException) {
            throw new IllegalStateException("not file", ioException);
        }
    }

}
