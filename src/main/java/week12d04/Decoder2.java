package week12d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder2 {

    public String binaryFileDecoder (String fileName){
        Path path = Path.of(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bytes = Files.readAllBytes(path);
            for (byte b: bytes) {
                char c = (char)(b + 10);
                sb.append(c);
            }
        } catch (IOException e) {
            throw  new IllegalStateException("can not read file", e);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Decoder2 en = new Decoder2();
        System.out.println(en.binaryFileDecoder("secret.dat"));
    }
}
