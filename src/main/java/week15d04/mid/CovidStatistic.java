package week15d04.mid;

import week15d05.mid.CasesComparator;
import week15d05.mid.DeathComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CovidStatistic {

    public List<CovidNumbersPerWeek> getCovidNumbers() {
        return new ArrayList<>(covidNumbers);
    }

    private List<CovidNumbersPerWeek> covidNumbers = new ArrayList<>();

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
        addCovidNumbers(temp);
    }

    private void addCovidNumbers(String[] temp) {
        String country = temp[4];
        String year_Week = temp[1];
        if (temp[2].isBlank()) {
            temp[2] = "0";
        }
        if (temp[3].isBlank()) {
            temp[3] = "0";
        }
        if (temp[7].isBlank()) {
            temp[7] = "0";
        }
        int cases_Weekly = Integer.parseInt(temp[2]);
        int death_Weekly = Integer.parseInt(temp[3]);
        int population = Integer.parseInt(temp[7]);

        CovidNumbersPerWeek cw = new CovidNumbersPerWeek(country, year_Week, cases_Weekly,death_Weekly,population);
        covidNumbers.add(cw);
    }

    public List<CovidNumbersPerWeek> covidStatisticTop3ByCountry (String country) {
        List<CovidNumbersPerWeek> result = new ArrayList<>();
        for (CovidNumbersPerWeek cw: getCovidNumbers()) {
            if (cw.getCountry().equals(country)) {
                result.add(cw);
            }
        }
        Collections.sort(result, new CasesComparator());
        return result.subList(0, 3);
    }

    public List<CovidNumbersPerWeek> covidStatisticDeathTop3ByCountry (String country) {
        List<CovidNumbersPerWeek> result = new ArrayList<>();
        for (CovidNumbersPerWeek cw: getCovidNumbers()) {
            if (cw.getCountry().equals(country)) {
                result.add(cw);
            }
        }
        Collections.sort(result, new DeathComparator());
        return result.subList(0, 3);
    }

    public CovidNumbersPerWeek covidSumCasesAndDeathByCountry (String country) {
        CovidNumbersPerWeek result = null;
        int sumCases = 0;
        int sumDeath = 0;
        int population = 0;
        for (CovidNumbersPerWeek cw: getCovidNumbers()) {
            if (cw.getCountry().equals(country)) {
                sumCases += cw.getCases_Weekly();
                sumDeath += cw.getDeath_Weekly();
                population = cw.getPopulation();
            }
        }
        result= new CovidNumbersPerWeek(country,"2021-7", sumCases, sumDeath, population);
        return result;
    }

    public List<CovidNumbersPerWeek> sortedSumCasesByCountry () {
        List<CovidNumbersPerWeek> result = new ArrayList<>();
        Set<String> countries = new HashSet<>();
        for(CovidNumbersPerWeek cw: getCovidNumbers()) {
            countries.add(cw.getCountry());
        }
        for (String s: countries) {
            result.add(covidSumCasesAndDeathByCountry(s));
        }
        Collections.sort(result, new CasesComparator());
        return result;
    }

    public List<CovidNumbersPerWeek> sortedSumDeathByCountry () {
        List<CovidNumbersPerWeek> result = new ArrayList<>();
        Set<String> countries = new HashSet<>();
        for(CovidNumbersPerWeek cw: getCovidNumbers()) {
            countries.add(cw.getCountry());
        }
        for (String s: countries) {
            result.add(covidSumCasesAndDeathByCountry(s));
        }
        Collections.sort(result, new DeathComparator());
        return result;
    }

    public Map<Integer, CovidNumbersPerWeek> sortedSumCasesByCountryRateForPopulation () {
        List<CovidNumbersPerWeek> resultList = new ArrayList<>();
        Map<Integer, CovidNumbersPerWeek> resultMap = new TreeMap<>();
        Set<String> countries = new HashSet<>();
        for(CovidNumbersPerWeek cw: getCovidNumbers()) {
            countries.add(cw.getCountry());
        }
        for (String s: countries) {
            resultList.add(covidSumCasesAndDeathByCountry(s));
        }
        int rate;
        for (CovidNumbersPerWeek cw: resultList) {
            rate = 0;
            if (cw.getPopulation() > 0) {
                rate = (int) Math.round((cw.getCases_Weekly() * 1.0 / cw.getPopulation()) * 10000000);
            }
            resultMap.put(rate, cw);
        }
        return resultMap;
    }

    public Map<Integer, CovidNumbersPerWeek> sortedSumDeathByCountryRateForPopulation () {
        List<CovidNumbersPerWeek> resultList = new ArrayList<>();
        Map<Integer, CovidNumbersPerWeek> resultMap = new TreeMap<>();
        Set<String> countries = new HashSet<>();
        for(CovidNumbersPerWeek cw: getCovidNumbers()) {
            countries.add(cw.getCountry());
        }
        for (String s: countries) {
            resultList.add(covidSumCasesAndDeathByCountry(s));
        }
        int rate;
        for (CovidNumbersPerWeek cw: resultList) {
            rate = 0;
            if (cw.getPopulation() > 0) {
                rate = (int) Math.round((cw.getDeath_Weekly() * 1.0 / cw.getPopulation()) * 100000000);
            }
            resultMap.put(rate, cw);
        }
        return resultMap;
    }



    public static void main(String[] args) {
        CovidStatistic cs = new CovidStatistic();
        cs.readFromFileToLines("src/main/java/week15d04/covid19.csv");
//        System.out.println(cs.getCovidNumbers());
//        System.out.println(cs.covidStatisticTop3ByCountry("Hungary"));
//        System.out.println(cs.covidStatisticDeathTop3ByCountry("Hungary"));
//        System.out.println(cs.covidSumCasesAndDeathByCountry("United_States_of_America"));
//        System.out.println(cs.sortedSumCasesByCountry());
//        System.out.println(cs.sortedSumDeathByCountry());
        System.out.println(cs.sortedSumCasesByCountryRateForPopulation());
//        System.out.println(cs.sortedSumDeathByCountryRateForPopulation());
    }

}
