package _aaa.variable;

import _aaa.Basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Histogram {
    public String createHistogram (BufferedReader br) {
        try {
            StringBuilder result = new StringBuilder();
            String line;
            int number;
            while((line = br.readLine()) != null) {
                number = Integer.parseInt(line);
                for (int i = 0; i < number; i++) {
                    result.append('*');
                }
                result.append("\n");
            }
            return result.toString();
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }

    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(HistogramTest.class.getResourceAsStream("histogram.txt")))) {
//            String result = new exam03.Histogram().createHistogram(reader);
////            System.out.println(result);
//            assertEquals("***\n" +
//                    "****\n" +
//                    "**\n" +
//                    "*\n", result);
//        }

        Histogram ba = new Histogram();
        Path path = Path.of("cities.txt");
        try (BufferedReader br = Files.newBufferedReader(path)){
            ba.createHistogram(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

}
