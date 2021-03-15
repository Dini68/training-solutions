package week13d04;

import week13d03.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Process {

    private final static int BLOCK = 4;

    private List<ObjectUnit> objectUnits = new ArrayList<>();

    private Object validSomeThing0(String hours) {
        try {
            return Integer.parseInt(hours);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Error" + hours, nfe);
        }
    }
    private String validSomeThing1 (String word) {
        if (word.isBlank()) {
            throw new IllegalArgumentException("Word is missing");
        }
        return word;
    }
    private String validSomeThing2 (String word) {
        if (word.isBlank()) {
            throw new IllegalArgumentException("Word is missing");
        }
        return word;
    }
    private String validSomeThing3 (String word) {
        if (word.isBlank()) {
            throw new IllegalArgumentException("Word is missing");
        }
        return word;
    }


    private ObjectUnit createObjectUnit(String[] lines) {
        Object someThing0 = validSomeThing0(lines[0]);
        Object someThing1 = validSomeThing1(lines[1]);
        Object someThing2 = validSomeThing2(lines[2]);
        Object someThing3 = validSomeThing3(lines[3]);
        return new ObjectUnit(someThing0, someThing1, someThing2, someThing3);
    }

    private void addObjectUnits(BufferedReader br) throws IOException {
        String[] lines = new String[BLOCK];
        int index = 0;
        while ((lines[index] = br.readLine()) != null) {
            if (index == BLOCK - 1) {
                objectUnits.add(createObjectUnit(lines));
            }
            index = (index + 1) % BLOCK;
        }
//        isValidObjectUnits(index);

    }

    public void readFromFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)){
            addObjectUnits(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }
}
