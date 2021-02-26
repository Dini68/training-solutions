package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    private List<Station> stations = new ArrayList<>();

    public List<Station> getStations() {
        return new ArrayList<>(stations);
    }

    public List<String> getStationsInStorm(BufferedReader reader) {
        List<String> result = new ArrayList<>();
        try {
            String line ;
            int id = 0;
            String name = "";
            String lat = "";
            String lng = "";
            String description = "";
            int level = 0;
            String groupId = "";
            String stationType = "";
            int row = -1;
            while ((line = reader.readLine()) != null) {
                if (row == 1) {
                    String temp = line.split(":")[1];
                    id = Integer.parseInt(temp.split(",")[0].substring(1));
                }
                if (row == 2) {
                    String temp = line.split(":")[1];
                    name = temp.split(",")[0].substring(2, temp.split(",")[0].length()-1);
                }
                if (row == 3) {
                    String temp = line.split(":")[1];
                    lat = temp.split(",")[0].substring(2, temp.split(",")[0].length()-1);
                }
                if (row == 4) {
                    String temp = line.split(":")[1];
                    lng = temp.split(",")[0].substring(2, temp.split(",")[0].length()-1);
                }
                if (row == 5) {
                    String temp = line.split(":")[1];
                    description = temp.split(",")[0].substring(2, temp.split(",")[0].length()-1);
                }
                if (row == 6) {
                    String temp = line.split(":")[1];
                    level = Integer.parseInt(temp.split(",")[0].substring(1));
                }
                if (row == 7) {
                    String temp = line.split(":")[1];
                    groupId = temp.split(",")[0].substring(2, temp.split(",")[0].length()-1);
                }
                if (row == 8) {
                    String temp = line.split(":")[1];
                    stationType = temp.substring(2, temp.split(",")[0].length()-1);
                    if (level == 3) {
                        result.add(name);
                    }
                    row = - 2;
                    stations.add(new Station(id, name, lat, lng, description, level, groupId, stationType));
                }
                row ++;
            }
            Collections.sort(result,  Collator.getInstance(new Locale("hu", "HU")));
            return result;

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }
}
