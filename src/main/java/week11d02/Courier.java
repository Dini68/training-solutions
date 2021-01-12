package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    private boolean isCorrect(Ride ride) {
        boolean isCorrect = true;

        if (ride == null) {
            throw new IllegalArgumentException("ride cannot be not null");
        }

        if (rides.isEmpty() && ride.getRideNr() != 1) {
            throw new IllegalArgumentException("The number of ride must be 1.");
        }

        if (rides.isEmpty() && ride.getRideNr() == 1) {
            return isCorrect;
        }

        int last = rides.size() - 1;
        if (rides.get(last).getDay() > ride.getDay()) {
            throw new IllegalArgumentException("The day of number is wrong.");
        }

        if (rides.get(last).getDay() < ride.getDay()) {
            if (ride.getRideNr() == 1) {
                return isCorrect;
            }
            else {
                throw new IllegalArgumentException("rideNR must be 1");
            }
        }

        if (rides.get(last).getDay() == ride.getDay()) {
            if (rides.get(last).getRideNr() == ride.getRideNr() - 1) {
                return isCorrect;
            }
            else {
                throw new IllegalArgumentException("rideNR is wrong");
            }
        }

        return isCorrect;
    }

    public void addRide(Ride ride) {
        if (isCorrect(ride)) {
            rides.add(ride);
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
}