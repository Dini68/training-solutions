package statements;

import java.util.Scanner;

public class DibByThree {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("This number divisible by 3: ");
        System.out.println(number % 3 == 0);
    }
}
