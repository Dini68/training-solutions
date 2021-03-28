package week08d05.senior;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public static final char OCEAN_CHARACTER = '0';

    public int longestOcean(String path) {
        int maxLength = 0;
        try (FileInputStream fis = new FileInputStream(path)) {
            maxLength = getMaxLength(fis);
        } catch (FileNotFoundException e) {
            throw new MyException("Wrong");
        } catch (IOException ioException) {
            System.out.println("IO fail");
        }
        return maxLength;
    }

    private int getMaxLength(FileInputStream fis) throws IOException {
        int max = 0;
        int input;
        int counter = 0;
        while ((input = fis.read()) != -1){
            if (input == OCEAN_CHARACTER){
                counter++;
            }
            else {
                max = getMax(max, counter);
                counter = 0;
            }
        }
        return max;
    }

    private int getMax(int max, int counter) {
        if (max < counter){
            max = counter;
        }
        return max;
    }

    public static void hello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.longestOcean("src/main/java/week08d05/senior/map.txt"));
        plane.hello();
        Plane.hello();
        hello();
    }
}
