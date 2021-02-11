package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Statik {

    private List<CovidPerWeek> cases = new ArrayList<>();

    public List<CovidPerWeek> getCases() {
        return new ArrayList<>(cases);
    }

    public void addCases (String line) {
        String[] value= line.split(",");
        if (value[4].equals("Hungary")) {
            cases.add(new CovidPerWeek(value[1], Integer.parseInt(value[2])));
        }
    }

    public List<CovidPerWeek> max3CovidNumberPerWeek () {
        List<CovidPerWeek> result = new ArrayList<>();
        List<CovidPerWeek> temp = new ArrayList<>(getCases());
        Collections.sort(temp);
        for (int i = 1; i < 4; i++) {
            result.add(temp.get(temp.size()-i));
        }
        return result;
    }
    public void readFromFileToLines (String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line;
            line = br.readLine();
            int serialNumber = 0;
            while ((line = br.readLine()) != null) {
                addCases(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public static void main(String[] args) {
        Statik ba = new Statik();
        ba.readFromFileToLines("src/main/java/week15d04/covid19.csv");
        System.out.println(ba.max3CovidNumberPerWeek());
    }
}
