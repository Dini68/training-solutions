package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Time time1 = new Time(12, 3, 43);

        Time time2 = new Time(4, 21, 38);

        System.out.println("Az első idöpont: " + time1.toString() +
                           " = " + time1.getInMinutes() + " perc");

        System.out.println("A második időpont: " + time2.toString() +
                           " = " + time2.getInSeconds() + " másodperc");

        System.out.println("Az első időpont korábbi, mint a második: " + time1.aerlierThan(time1, time2));
    }
}
