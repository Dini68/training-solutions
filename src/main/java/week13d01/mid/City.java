package week13d01.mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class City {

    public String readFromFileToLines (BufferedReader br) {
        String result = "";
        try {
            br.readLine();
            result = maxCityNameLength(br, result);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
        return result;
    }

    private String maxCityNameLength(BufferedReader br, String result) throws IOException {
        String line;
        int maxLength = 0;
        while((line = br.readLine()) != null) {
            if (maxLength < line.split(";")[1].length()) {
                maxLength = line.split(";")[1].length();
                result = line.split(";")[1];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        City ci = new City();
        Path path = Path.of("src/main/resources/iranyitoszamok-varosok.csv");
        try (BufferedReader br = Files.newBufferedReader(path)){
            System.out.println(ci.readFromFileToLines(br));
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }
}
