package week15d05.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GameOfThronesBattles {

    public Map<String, Integer> battlesNumberPerHouses = new LinkedHashMap<>();

    public Map<String, Integer> getBattlesNumberPerHouses() {
        return new LinkedHashMap<>(battlesNumberPerHouses);
    }

    public void readFromFileToLines (String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line;
            readHeader(br);
            while ((line = br.readLine()) != null) {
                lineProcess(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    private void readHeader(BufferedReader br) throws IOException {
        if (null != br.readLine()) {
            // headerLine
        }
    }

    public void lineProcess(String line) {
        String[] temp = line.split(",");
        addRulerHouses(temp);
    }

    private void addRulerHouses(String[] temp) {
        Set<String> namesPerBattle = new HashSet<>();
        for (int i = 5; i < 13; i++) {
            if (!temp[i].isBlank()) {
                namesPerBattle.add(temp[i]);
            }
        }
        for (String s: namesPerBattle) {
            if (!battlesNumberPerHouses.containsKey(s)) {
                battlesNumberPerHouses.put(s, 1);
            }
            else {
                battlesNumberPerHouses.put(s, battlesNumberPerHouses.get(s) + 1);
            }
        }
    }

    public Map.Entry<String, Integer> maxBattlesByHouse () {
        Map.Entry<String, Integer> maxElement = null;
        String result = "";
        int maxValue = 0;
        int value;
        for (Map.Entry<String, Integer> actual: getBattlesNumberPerHouses().entrySet()) {
            if (maxValue < actual.getValue()) {
                maxValue = actual.getValue();
                maxElement = actual;
            }
        }
        return maxElement;
    }

    public void sortedMap () {
        Map<String, Integer> sortedByName = new LinkedHashMap<>();
        Map<String, Integer> sortedByNumber = new LinkedHashMap<>();
        Map.Entry<String, Integer> result;
        List<String> sortedHousesNames;
        List<Integer> sortedNumbers;

        sortedHousesNames = new ArrayList<>(getBattlesNumberPerHouses().keySet());
        Collections.sort(sortedHousesNames);
        for (String s: sortedHousesNames) {
            sortedByName.put(s, getBattlesNumberPerHouses().get(s));
        }
        System.out.println(sortedByName);
        sortedNumbers = new ArrayList<>(getBattlesNumberPerHouses().values());
        Collections.sort(sortedNumbers, Comparator.reverseOrder());

        for (int i: sortedNumbers) {
            for (String key: sortedByName.keySet()) {
                if (sortedByName.get(key) == i) {
                    sortedByNumber.put(key, i);
                }
            }
        }
        System.out.println(sortedByNumber);
    }

    public static void main(String[] args) {
        GameOfThronesBattles gt = new GameOfThronesBattles();
        gt.readFromFileToLines("src/main/java/week15d05/battles.csv");
        System.out.println(gt.getBattlesNumberPerHouses());
        System.out.println(gt.maxBattlesByHouse());
        gt.sortedMap();
    }
}
