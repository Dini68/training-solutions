package week12d05.mid;

import _aaa.Basic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Index {
    public void readFromFileToLines (BufferedReader br) {
        try {
            String line;
//            skipHeader(br);
            int count = 0;
            while((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("nehéz")) {
                    count++;
                    System.out.println(line);
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }

    public static void main(String[] args) {
        Index in = new Index();
        Path path = Path.of("Index.html");
        try (BufferedReader br = Files.newBufferedReader(path)){
            in.readFromFileToLines(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

}
