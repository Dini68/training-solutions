package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem az 1. kör átmérőjét: ");
        int diameter= scanner.nextInt();
        scanner.nextLine();
        Circle circle1 = new Circle(diameter);

        System.out.print("Kérem a 2. kör átmérőjét: ");
        diameter= scanner.nextInt();
        scanner.nextLine();
        Circle circle2 = new Circle(diameter);

        System.out.print("Az 1. kör kerülete:\t" + circle1.perimeter());
        System.out.println("\t területe: " + circle1.area());
        System.out.print("A 2. kör kerülete:\t" + circle2.perimeter());
        System.out.println("\tterülete: " + circle2.area());
    }

}
