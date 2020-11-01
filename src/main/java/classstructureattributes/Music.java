package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Song song = new Song();

        System.out.println("Enter favorite song!");

        System.out.print("Band: ");
        song.band = scanner.nextLine();

        System.out.print("Title: ");
        song.title = scanner.nextLine();

        System.out.print("Length: ");
        song.length = scanner.nextInt();
        scanner.nextLine();

        System.out.println(song.band + ", " + song.title + " (" + song.length + " perc)");
    }
}
