package aaa;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class StringReadWriteToFile {

    public static void main(String[] args) {
        Path file = Path.of("test.txt");
            // String írása új fájlba egyben >> Files.writeString
        try {
            Files.writeString(file,"Blabla bla\nMégegyszer\nVégesor\n");
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
            // String hozzáírása egy létező fájlhoz egyben >> Files.writeString + APPEND
        try {
            Files.writeString(file, "Még egy sor\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("can not write file", e);
        }
            // String lista hozzáírása egy létező fájlhoz egyben >> Files.write + APPEND
        try {
            Files.write(file,List.of("Jack Doe", "Jane Doe"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("can not write file", e);
        }
            // Fájl beolvasása Stringbe egyben >> Files.readString
        try {
            String content = Files.readString(file);
            System.out.println(content);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
            // Fájl beolvasása Stringlistába soronként egyben >> Files.readAllLines
        try {
            List<String> contents = Files.readAllLines(file);
            System.out.println(contents);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
            // Bájtok beolvasása fájlból egyben Files.readALLBytes
        try {
            byte[] bytes = Files.readAllBytes(file);
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
            // Bájtok kiírása fájlba egyben Files.write
        try {
            Files.write(file, new byte[] {98, 99, 98, 99}, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("can not write file", e);
        }
            // Nagy méretű fájl beolvasása soronként >> BufferedReader reader.readLine()
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
            // Nagy méretű fájl kiírása soronként >> BufferedWriter writer.writeLine()
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            List<String> employees = List.of("John Doe", "Jack Doe");
            for (String st: employees) {
                writer.write(st +"\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
            // Különböző típusú fájl kiírása  >> PrintWriter writer.print()
        List<String> employees = List.of("John Doe", "Jane Doe", "Jack Doe");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String st: employees) {
                writer.print(st);
                writer.print(',');
                writer.println(200_000);
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }

            // Kiírás StringWriterrel a konzolra
        file = Path.of("employees.txt");
        List<String> employees2 = List.of("John Doe", "Jane Doe", "Jack Doe");
        try(StringWriter stringWriter = new StringWriter()) {
            PrintWriter printWriter = new PrintWriter(stringWriter);
            for (String st: employees) {
                printWriter.print(st);
                printWriter.print(',');
                printWriter.println(200_000);
            }
            System.out.println(stringWriter.toString());

        }
        catch (IOException ioe){
            throw new IllegalStateException("can not write", ioe);
        }
            // Bináris állomány beolvasása darabokban
    }
}
