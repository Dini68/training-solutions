package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("5 + 8 * (4 - 2) / 0.5");

        System.out.print("Mennyi a kifejezés eredménye? ");
        double tipp = scanner.nextDouble();
        scanner.nextLine();

        if (Math.abs(tipp-37) < 0.0001) {
            System.out.println("A megoldás helyes.");
        }else {
            System.out.println("A megoldás hibás.");
        }
    }
}
