package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int random100 = rnd.nextInt(100); // 0 - 9-ig generálhat számokat, 10-et sosem generál
        boolean isCorrectTip = false;
        int count = 0;
        int tip = 0;
        while (!isCorrectTip && count < 6) {
            System.out.print("Kérem a(z) " + (count + 1) + " tippet: ");
            tip = Integer.parseInt(scanner.nextLine());
            if (random100 < tip) {
                System.out.println("A tippelt szám nagyobb");
            }
            if (random100 > tip) {
                System.out.println("A tippelt szám kisebb");
            }
            if (random100 == tip) {
                isCorrectTip = true;
            }
            count++;
        }
        if (isCorrectTip) {
            System.out.println("Gratulálok, eltaláltad a számot");
        }
        else {
            System.out.println("Nem sikerült, a gondolt szám: " + random100);
        }

    }
}
