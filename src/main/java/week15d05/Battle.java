package week15d05;

import _aaa.Basic;
import week15d04.CovidPerWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Battle {

    private Map<String, Integer> battlesPerHouses = new LinkedHashMap<>();

    public Map<String, Integer> getBattlesPerHouses() {
        return new LinkedHashMap<>(battlesPerHouses);
    }
    private int max = 0;

    private String maxkey = "";

    public void addBattlesPerHouses (String line) {
        String[] value= line.split(",");
        for (int i = 5; i < 13; i++) {
            if (!battlesPerHouses.containsKey(value[i])) {
                if (!value[i].isEmpty()) {
                    battlesPerHouses.put(value[i], 1);
                    if (max < 1) {
                        max = 1;
                        maxkey = value[i];
                    }
                }
            }
            else {
                battlesPerHouses.put(value[i], battlesPerHouses.get(value[i]) + 1);
                if (max < battlesPerHouses.get(value[i])) {
                    max = battlesPerHouses.get(value[i]);
                    maxkey = value[i];
                }
            }
        }
    }


    public void readFromFileToLines (String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line = br.readLine();
            while (null != (line = br.readLine())) {
                addBattlesPerHouses(line);
            }
            System.out.println(maxkey + " " + max);
            System.out.println(battlesPerHouses);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public static void main(String[] args) {
        Battle ba = new Battle();
        ba.readFromFileToLines("src/main/java/week15d05/battles.csv");
    }

}
