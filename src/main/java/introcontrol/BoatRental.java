package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Team number: ");
        int teamNumber = scanner.nextInt();

        if ((teamNumber < 3) || (teamNumber > 8) ||
            ((teamNumber > 5) && (teamNumber < 8))) {
            System.out.println("2 személyes csónak kiadva.");
        }

        if ((teamNumber == 3) || (teamNumber > 7)){
            System.out.println("3 személyes csónak kiadva.");
        }

        if (teamNumber > 3 ) {
            System.out.println("5 személyes csónak kiadva.");
        }

        if (teamNumber > 10) {
            System.out.println("A parton maradtak: " + (teamNumber - 10));
        }
    }
}
