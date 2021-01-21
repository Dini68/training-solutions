package week12d04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder3 {

    public String binaryFileDecoder (String fileName){
        Path path = Path.of(fileName);
        StringBuilder sb = new StringBuilder();
        try (InputStream is = Files.newInputStream(path)){
            byte[] buffer = new byte[100];
            int size;
            while ((size = is.read(buffer)) > 0) {
                System.out.println(size);
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i] + 10);
                    sb.append(c);
                }
            }
        } catch (IOException e) {
            throw  new IllegalStateException("can not read file", e);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Decoder3 en = new Decoder3();
        System.out.println(en.binaryFileDecoder("secret.dat"));
    }
}
