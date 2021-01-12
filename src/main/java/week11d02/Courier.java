package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("ride cannot be not null");
        }

        boolean added = false;

        if (rides.isEmpty() && ride.getRideNr() != 1) {
            throw new IllegalArgumentException("The number of ride must be 1.");
        }

        if (rides.isEmpty() && ride.getRideNr() == 1) {
            rides.add(ride);
            added = true;
        }


        int last = rides.size() - 1;

        if (rides.get(last).getDay() > ride.getDay() && !added) {
            throw new IllegalArgumentException("The day of number is wrong.");
        }

        if (rides.get(last).getDay() < ride.getDay() && !added) {
            if (ride.getRideNr() == 1) {
                rides.add(ride);
                added = true;
            }
            else {
                throw new IllegalArgumentException("rideNR must be 1");
            }
        }

        if (rides.get(last).getDay() == ride.getDay() && !added) {
            if (rides.get(last).getRideNr() == ride.getRideNr() - 1) {
                rides.add(ride);
            }
            else {
                throw new IllegalArgumentException("rideNR is wrong");
            }
        }
    }

    public int firstFreeDay() {
        boolean freeday = true;
        for (int day = 1; day <= 7; day++) {
            for (Ride item : rides) {
                if (item.getDay() == day) {
                    freeday = false;
                }
            }
            if (freeday) {
                return day;
            }
            freeday = true;
        }
        return -1;
    }

    public static void main(String[] args) {
        Courier cu = new Courier();
        Ride r1=new Ride(3,1,34.5);
        cu.addRide(r1);
        Ride r2=new Ride(2,1,34.5);
        cu.addRide(r2);
        System.out.println(cu.firstFreeDay());
    }
}