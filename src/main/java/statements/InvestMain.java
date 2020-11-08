package statements;

import java.util.Scanner;

public class InvestMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Befektetett összeg: ");
        int fund =  scanner.nextInt();
        scanner.nextLine();

        System.out.print("Kamatláb: ");
        int interestRate =  scanner.nextInt();
        scanner.nextLine();

        Investment investment = new Investment(fund, interestRate);

        System.out.println("Tőke: " + fund);

        System.out.print("Hány napra számoljam a hozamot: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hozam " + days + " napra: " + investment.getYield(days));

        System.out.print("Hány nap után veszi ki a pénzt: ");
        int days2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("A kivett összeg " + days2 + " nap után: " + investment.close(days2));

        System.out.print("Hány nap után veszi ki a pénzt: ");
        int days3 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("A kivett összeg " + days3 + " nap után: " + investment.close(days3));

    }
}
