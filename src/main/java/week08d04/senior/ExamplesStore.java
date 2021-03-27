package week08d04.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public static final String  TITLE_MARKER = "# ";

    private List<String> titles = new ArrayList<>();

    public List<String> getTitlesOfExamples() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream("examples.md")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addTitles(line);
            }
            return titles;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void addTitles(String line) {
        if (line.startsWith(TITLE_MARKER)) {
            titles.add(line.substring(2));
        }
    }

    public static void main(String[] args) {
        ExamplesStore es = new ExamplesStore();
        System.out.println(es.getTitlesOfExamples());
    }
}
