package week12d04.mid;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Decoder {

    public void decode (String filename) {
        Path path = Path.of(filename);
        try (InputStream ip = Files.newInputStream(path)){
            byte[] bytes = ip.readAllBytes();
            for (byte b: bytes) {
                System.out.print((char)(b + 10));
            }
            writeToFile(bytes);
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }
    }

    private void writeToFile(byte[] bytes) {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("decode-secret.txt"))){
            for (byte b: bytes) {
                bw.write((char)(b + 10));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        new Decoder().decode("secret.dat");
    }
}
