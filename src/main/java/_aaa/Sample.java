package _aaa;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = scanner.nextLine();

        System.out.println("What's your year of birth?");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
//        Vigyázz a nextInt() metódussal, mert az nem olvassa be a sorvége jelet, és a következő nextLine() nem fog működni.
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.nextLine(); //Ez fogja az ottmaradt sorvége jelet beolvasni

        System.out.println("What's your name?");
        String name2 = scanner.nextLine();
        System.out.println("How old are you?");
//        Helyette jobb lehet a következő (NumberFormatException kivételt dob, ha nem szám):
        String line = scanner.nextLine();
        int age2 = Integer.parseInt(line); //

    }
}
