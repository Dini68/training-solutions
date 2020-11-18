package finalmodifier;

import java.util.Scanner;

public class PiMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.print("Kérem a henger sugarát: ");
        double r = scanner.nextInt();

        System.out.print("Kérem a henger magasságát: ");
        double h = scanner.nextInt();

        System.out.println("A henger térfogat: " + cylinderCalculator.calculateVolume(r, h));
        System.out.println("A henger felszíne: " + cylinderCalculator.calculateSurfaceArea(r, h));

    }
}
