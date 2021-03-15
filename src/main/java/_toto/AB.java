package _toto;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class AB {
    public static void main(String[] args) throws IOException {
        new AB().start();
    }

    private void start() throws IOException {
        System.out.println("Java Commmander 1.0");
        File workingDirectory = new File("");
        System.out.println(workingDirectory.getAbsolutePath());
        String commandText = readLine();
        if ("pwd".equals((commandText))) {
            System.out.println(workingDirectory.getAbsolutePath());
        }
    }

    private String readLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
