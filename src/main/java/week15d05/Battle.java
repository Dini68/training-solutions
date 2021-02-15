package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Battle {

    private List<BattleNumberByHouses> battlesPerHouses = new ArrayList<>();

    public List<BattleNumberByHouses> getBattlesPerHouses() {
        return new ArrayList<>(battlesPerHouses);
    }

    public void readFromFileToLines (String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line = br.readLine();
            while (null != (line = br.readLine())) {
                addBattlesPerHouses(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public void addBattlesPerHouses (String line) {
        String[] value= line.split(",");
        Set<String> temp = new LinkedHashSet<>();
        String name;
        int count;
        for (int i = 5; i < 13; i++) {
            temp.add(value[i]);
        }
        for (BattleNumberByHouses bn : getBattlesPerHouses()) {
            if (temp.contains(bn.getName())) {
                bn.setNumber(bn.getNumber() + 1);
            }
            else {
//                battlesPerHouses.add(BattleNumberByHouses);
            }
        }
    }

    public String maxBattlesPerHouse() {
        String result = "";
        int maxValue = 0;
        int value = 0;
        String maxKey = "";
  //      for (String key: battlesPerHouses.keySet()) {
//            value = battlesPerHouses.get(key);
//            if (maxValue < value) {
//                maxValue = value;
//                maxKey = key;
//            }
//        }
//        result = maxKey;
        return result;
    }

    public static void main(String[] args) {
        Battle ba = new Battle();
        ba.readFromFileToLines("src/main/java/week15d05/battles.csv");
        System.out.println(ba.getBattlesPerHouses());
        System.out.println(ba.maxBattlesPerHouse());
    }

}
