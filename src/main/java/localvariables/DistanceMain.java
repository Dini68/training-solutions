package localvariables;

import java.util.Scanner;

public class DistanceMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Distance: ");
        double length = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Exact? ");
        Boolean exact = scanner.hasNext();

        Distance distance = new Distance(length, exact);

        System.out.println("Distance: " + length);
        System.out.println("Exact: " + exact);

        int distwhole = (int)distance.getDistanceInKm();

        System.out.println("part of whole: " + distwhole);
    }
}
