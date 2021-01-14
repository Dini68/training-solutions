package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public String fileName(int i) {
        String numberStr;
        if (i < 10) {
            numberStr = "0" + i;
        } else {
            numberStr = Integer.toString(i);
        }
        return "number" + numberStr + ".txt";
    }

    public int filesReader(int fileNr) {
        int content = 0;
        if (Files.isRegularFile(Path.of(fileName(fileNr)))) {
            try {
                content = Integer.parseInt(Files.readString(Path.of(fileName(fileNr))));
            } catch (IOException e) {
                throw new IllegalStateException("Can not read", e);
            }
        }
        return content;
    }


    public int sumNumbers() {
        int sum = 0;
        for (int i = 0; i < 99; i++) {
            sum += filesReader(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        FilesSum filesSum = new FilesSum();
        System.out.println(filesSum.sumNumbers());
    }
}
