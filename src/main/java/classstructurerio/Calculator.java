package classstructurerio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 2 number!");

        System.out.print("1. number: ");
        int number1 = scanner.nextInt();

        System.out.print("2. number: ");
        int number2 = scanner.nextInt();

        System.out.println(number1 + "+" + number2);
        System.out.println(number1 + number2);

    }
}
