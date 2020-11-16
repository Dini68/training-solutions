package week02;

import java.util.Scanner;

public class Controller {

    private Office office;

    public void readOffice(){
        office = new Office();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Meeting room number: 4");
//        int meetingRoomNumber = scanner.nextInt();
        int meetingRoomNumber = 4;
//        scanner.nextLine();

        for(int i = 0; i < meetingRoomNumber; i++) {
            String name = "";
            if (i==0) { name = "kicsi"; }
            if (i==1) { name = "közepes"; }
            if (i==2) { name = "nagy"; }
            if (i==3) { name = "legnagyobb"; }
            System.out.println(i + 1 + ". meeting room name: " + name);
//            String name = scanner.nextLine();

            int  length = 0;
            if (i==0) { length = 3; }
            if (i==1) { length = 4; }
            if (i==2) { length = 5; }
            if (i==3) { length = 6; }
            System.out.println(i + 1 + ". meeting room length: " + length);
//            int length = scanner.nextInt();
//            scanner.nextLine();

            int  width = 0;
            if (i==0) { width = 4; }
            if (i==1) { width = 5; }
            if (i==2) { width = 6; }
            if (i==3) { width = 7; }
            System.out.println(i + 1 + ". meeting room width: " + width);
//            int width = scanner.nextInt();
//            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(name, length, width);
            office.addMeetingRoom(meetingRoom);


        }
    };

    public void printMenu() {
        System.out.println();
        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján");
    };

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Menüpont választás: ");
        int menuPoint = scanner.nextInt();
        scanner.nextLine();

        if (menuPoint == 1) { office.printNames();
        }
        if (menuPoint == 2) { office.printNamesReverse();
        }
        if (menuPoint == 3) { office.printEventNames();
        }
        if (menuPoint == 4) { office.printAreas();
        }
        if (menuPoint == 5) { office.printMeetingRoomsWithName("nagy");
        }
        if (menuPoint == 6) { office.printMeetingRoomsContains("zEP");
        }
        if (menuPoint == 7) {office.printAreasLargerThan(19);
        }
    };

    public static void main(String[] args) {

        Controller controller = new Controller();

        controller.readOffice();

        controller.printMenu();

        controller.runMenu();
    }
}

