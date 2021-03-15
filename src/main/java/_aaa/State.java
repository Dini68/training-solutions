package _aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class State {

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
        Path path;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(State.class.getResourceAsStream("/stateregister.txt")))){
            ba.readFromFileToLines(br);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
    }

}
