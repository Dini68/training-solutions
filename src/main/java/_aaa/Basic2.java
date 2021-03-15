package _aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Basic2 {

    public void readFromFileToLines (BufferedReader br) {
        try {
            String line;
//            skipHeader(br);
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }

    public static void main(String[] args) {
        Basic2 ba = new Basic2();
        Path path = Path.of("cities.txt");
        try (BufferedReader br = Files.newBufferedReader(path)){
            ba.readFromFileToLines(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }
}
