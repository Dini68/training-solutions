package _aaa;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Something {

    public static void main(String[] args) {
//        String s = "John;1980";
//        String[] parts = s.split(";"); // ; a separator karakter
//        String name = parts[0];
//        int yearOfBirth = Integer.parseInt(parts[1]);
//        System.out.println(Arrays.toString(parts));
        String s = "aáü +bcd8";
        for (char c : s.toCharArray()) {
            System.out.print(c + " is letter:  ");
            System.out.println(Character.isLetter(c));
            System.out.print(c + " is number:  ");
            System.out.println(Character.isDigit(c));
        }
        Random rnd = new Random();
        System.out.println(rnd.nextInt()); // int számot generál
        System.out.println(rnd.nextDouble()); // 0 és 1 között double
        int randomNumberTo10 = rnd.nextInt(10); // 0 - 9-ig generálhat számokat, 10-et sosem generál
        System.out.println(randomNumberTo10);

        StringBuilder sb = new StringBuilder();
        String name = "John";
        int birth = 1980;
        int month = 3;
        double average = 1883.4567;
        String formatted = String.format("Name: %s, year of birth: %d month: %d average: %.2f", name, birth, month, average);
        System.out.println(formatted);
        System.out.printf("Name: %s, year of birth: %d month: %02d average: %.3f", name, birth, month, average);

        //        Scanner scanner = new Scanner(System.in);
//        System.out.print("What's your name? ");
//        String name = scanner.nextLine();
//
//        System.out.print("How old are you? ");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("How old are you? ");
//        String line = scanner.nextLine();
//        int age2 = Integer.parseInt(line);
//
//        String fruit = "Apple";
//        boolean startsWith = fruit.startsWith("app");
//        System.out.println(startsWith);
//        boolean endsWith = fruit.endsWith("le");
//        System.out.println(endsWith);


    }
}
