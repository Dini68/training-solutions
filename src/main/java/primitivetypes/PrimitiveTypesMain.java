package primitivetypes;

import java.util.Scanner;

public class PrimitiveTypesMain {

    public static void main(String[] args) {

        PrimitiveTypes primitiveTypes = new PrimitiveTypes();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Number by 10: ");
        int number = scanner.nextInt();

        String s1 = primitiveTypes.toBinaryString(number);
        System.out.println("Number by 2: " + s1);

        String s2 = Integer.toBinaryString(number);
        System.out.println("by java method: " + s2);

        System.out.println("Equals? " + s1.equals(s2));
    }
}
