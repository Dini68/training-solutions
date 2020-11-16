package week02;

import com.sun.source.tree.DoWhileLoopTree;

import java.util.Scanner;

public class Controller {

    private Office office;

    public void readOffice(){

        office = new Office();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem a tárgyalók számát: ");
        int meetingRoomNumber = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < meetingRoomNumber; i++) {

            System.out.print(i + 1 + ". tárgyaló neve: ");
            String name = scanner.nextLine();

            System.out.print(i + 1 + ". tárgyaló szélessége: ");
            int width = scanner.nextInt();
            scanner.nextLine();

            System.out.print(i + 1 + ". tárgyaló hosszúsága: ");
            int length = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(name, length, width);
            office.addMeetingRoom(meetingRoom);
        }
    };

    public void printMenu() {
        System.out.println();
        System.out.println(
                "1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n" +
                "8. Kilépés");
    };

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        int menuPoint = 0;
        do {
            System.out.print("Menüpont választás: ");
            menuPoint = scanner.nextInt();
            scanner.nextLine();

            if (menuPoint == 1) {
                office.printNames();
            }
            if (menuPoint == 2) {
                office.printNamesReverse();
            }
            if (menuPoint == 3) {
                office.printEventNames();
            }
            if (menuPoint == 4) {
                office.printAreas();
            }
            if (menuPoint == 5) {

                System.out.print("Kérem a tárgyaló nevét: ");
                String name = scanner.nextLine();
                office.printMeetingRoomsWithName(name);
            }
            if (menuPoint == 6) {

                System.out.print("Kérem a névtöredéket a kereséshez: ");
                String part = scanner.nextLine();
                office.printMeetingRoomsContains(part);
            }
            if (menuPoint == 7) {

                System.out.print("Kérem a tárgyaló mimimális méretét a kereséshez: ");
                int minArea = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(minArea);
            }
        } while (!(menuPoint == 8));
    }

    public static void main(String[] args) {

        Controller controller = new Controller();

        controller.readOffice();

        controller.printMenu();

        controller.runMenu();
    }
}

