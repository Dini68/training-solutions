package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Histogram {

    public String createHistogram(BufferedReader br) {
        StringBuilder result = new StringBuilder();
        try  {
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

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Histogram.class.getResourceAsStream("/histogram.txt")));
        String result = new Histogram().createHistogram(reader);
        System.out.println(result);
//            assertEquals("***\n" +
//                    "****\n" +
//                    "**\n" +
//                    "*\n", result);
    }

}

