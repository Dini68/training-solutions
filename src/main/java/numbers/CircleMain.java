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

        System.out.print("Az 1. kör kerülete:\t" + Math.round(circle1.perimeter() * 1000) / 1000.0);
        System.out.println("\t területe: " + Math.round(circle1.area() * 1000) / 1000.0);
        System.out.print("Az 2. kör kerülete:\t" + Math.round(circle2.perimeter() * 1000) / 1000.0);
        System.out.println("\t területe: " + Math.round(circle2.area() * 1000) / 1000.0);
    }

}
