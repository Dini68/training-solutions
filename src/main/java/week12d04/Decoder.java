package week12d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder {

    public void binaryFileDecoder (String fileName){
        Path path = Path.of(fileName);
        try {
            byte[] bytes = Files.readAllBytes(path);
            for(int i = 0; i < bytes.length; i++) {
                System.out.print((char)(bytes[i] + 10));
            }
        } catch (IOException e) {
            throw  new IllegalStateException("can not read file", e);
        }
    }

    public static void main(String[] args) {
        Decoder en = new Decoder();
        en.binaryFileDecoder("secret.dat");
    }
}
