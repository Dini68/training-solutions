package javaapi;

import java.util.Scanner;

public class Upper {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sentence: ");
        String s = scanner.nextLine();

        System.out.println(s + " nagybetűvel:");
        System.out.println(s.toUpperCase());
    }
}
