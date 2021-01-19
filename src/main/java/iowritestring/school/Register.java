package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {



    public void newMark(Path name, int mark) {
        Path path = name;
        if (Files.exists(path)) {
            try {
                Files.writeString(path, mark + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IllegalStateException("Can not write file", e);
            }
        } else {
            try {
                Files.writeString(path, mark + "\n");
            } catch (IOException e) {
                throw new IllegalStateException("Can not write file", e);
            }
        }
    }

    public void average(Path name) {
        double average = 0;
        double sum = 0;
        Path path = name;
        if (Files.exists(path)) {
            try {
                List<String> marks = Files.readAllLines(path);
                for (String m: marks) {
                    sum += Integer.parseInt(m);
                }
                average = Math.round(sum * 100 / marks.size()) / 100.0;
                Files.writeString(path, "average: " + average + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IllegalStateException("Can not read file");
            }
        }
    }

    public static void main(String[] args) {
//        new Register().newMark("Kovács Hunor", 3);
//        new Register().newMark("Kovács Dénes", 4);
//        new Register().newMark("Kovács Hunor", 5);
//        new Register().newMark("Kovács Dénes", 4);
//        new Register().newMark("Kovács Hunor", 5);
//        new Register().newMark("Kovács Dénes", 3);
//        new Register().newMark("Kovács Hunor", 5);
//        new Register().newMark("Kovács Dénes", 2);
//        new Register().average("Kovács Hunor");
//        new Register().average("Kovács Dénes");
//
    }
}
