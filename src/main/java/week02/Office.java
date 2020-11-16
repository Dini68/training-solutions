package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom mr : meetingRooms
        ) {
            System.out.println(mr.getName());
        }
    }

    public void printNamesReverse() {
        int j = meetingRooms.size();
        for (int i = 0; i < j; i++) {
            System.out.println(meetingRooms.get(j-i-1).getName());
        }
    }

    public void printEventNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(i + 1 +
                    ". "  + meetingRooms.get(i).getName() +
                    ":  sz="   + meetingRooms.get(i).getWidth() +
                    "  h=" + meetingRooms.get(i).getLength() +
                    "  T=" + meetingRooms.get(i).getArea());
        }

    }

    public void printMeetingRoomsWithName(String name) {

        for (int i = 0; i < meetingRooms.size(); i++) {
            if (name.equals(meetingRooms.get(i).getName())) {
                System.out.println(
                        meetingRooms.get(i).getName() +
                                " "   + meetingRooms.get(i).getWidth() +
                                " * " + meetingRooms.get(i).getLength() +
                                " = " + meetingRooms.get(i).getArea());

            }
        }

    }

    public void printMeetingRoomsContains(String part) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getName().toUpperCase().contains(part.toUpperCase())) {
                System.out.println(
                        meetingRooms.get(i).getName() +
                                " "   + meetingRooms.get(i).getWidth() +
                                " * " + meetingRooms.get(i).getLength() +
                                " = " + meetingRooms.get(i).getArea());

            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.get(i).getArea() > area) {
                System.out.println(
                        meetingRooms.get(i).getName() +
                                " "   + meetingRooms.get(i).getWidth() +
                                " * " + meetingRooms.get(i).getLength() +
                                " = " + meetingRooms.get(i).getArea());

            }
        }

    }
}
