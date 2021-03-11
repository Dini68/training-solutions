package exam03retake01;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owls = new HashMap<>();

    public Map<String, Integer> getOwls() {
        return new HashMap<>(owls);
    }

    public void readFromFile(BufferedReader reader) throws IOException {

        String line;
        while ((line = reader.readLine())  != null) {
            String county = line.split("=")[0];
            int count = Integer.parseInt(line.split("=")[1]);
            System.out.println(line);
            owls.put(county, count);
        }
    }

    public int getNumberOfOwls(String s) {
        return getOwls().get(s);
    }

    public static void main(String[] args) {
        OwlCounter owlCounter = new OwlCounter();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(OwlCounter.class.getResourceAsStream("owls.txt")))) {
            owlCounter.readFromFile(reader);
        } catch (IOException ioException) {
            throw new IllegalStateException("not read file", ioException);
        }

    }
}
