package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Statik {

    private final List<CovidPerWeek> cases = new ArrayList<>();

    public List<CovidPerWeek> getCases() {
        return new ArrayList<>(cases);
    }

    public List<Top3> countriesList = new ArrayList<>();

    private String actualCountry = "Afghanistan";

    public void addCases (String line) {
        String[] value= line.split(",");
        if (value[4].equals("Hungary")) {
            cases.add(new CovidPerWeek(value[1], Integer.parseInt(value[2]), "Hungary"));
        }
    }

    public void addCases2 (String line) {
        String[] value= line.split(",");
        if (!value[4].equals(actualCountry)) {
//            System.out.println(max3CovidNumberPerWeek());
            max3CovidNumberPerWeek();
            actualCountry = value[4];
            cases.clear();
        }
        if (value[7].equals("")) {
            cases.add(new CovidPerWeek(value[1], Integer.parseInt(value[2]), value[4]));
        }
        else {
            cases.add(new CovidPerWeek(value[1], Integer.parseInt(value[2]), value[4]));
        }
    }

    public List<CovidPerWeek> max3CovidNumberPerWeek () {
        List<CovidPerWeek> result = new ArrayList<>();
        List<CovidPerWeek> temp = new ArrayList<>(getCases());
        Collections.sort(temp);
        CovidPerWeek cpw ;
        List<String> top3 = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            cpw = temp.get(temp.size()-i);
            result.add(cpw);
            top3.add(cpw.getCountry() + " " + cpw.getWeek() + " " + cpw.getCaseNumber());
        }
        countriesList.add(new Top3(temp.get(temp.size()-1).getCaseNumber() , top3));
        return result;
    }
    public void readFromFileToLines (String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line = br.readLine();
            while (null != (line = br.readLine())) {
                addCases2(line);
            }
            Collections.sort(countriesList);
            for (int i = 0; i < countriesList.size(); i++) {
                System.out.println(countriesList.size()-i + ". " + countriesList.get(i));
            }
            //System.out.println(countriesList);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public static void main(String[] args) {
        Statik ba = new Statik();
        ba.readFromFileToLines("src/main/java/week15d04/covid19.csv");
//        System.out.println(ba.max3CovidNumberPerWeek());
    }
}
