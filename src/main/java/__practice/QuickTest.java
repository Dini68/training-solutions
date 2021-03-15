package __practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickTest {
    public List<String> readLines(BufferedReader reader) {
        List<String> result = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(Arrays.toString(line.split(";")));
                result.add(line);
            }
            return result;
        } catch (IOException ioException) {
            throw new IllegalStateException("not read file", ioException);
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(QuickTest.class.getResourceAsStream("iranyitoszamok-varosok.csv")));
        new QuickTest().readLines(reader);
    }

}
