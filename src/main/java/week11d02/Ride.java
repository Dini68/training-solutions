package week11d02;

public class Ride {
    private int day;
    private int rideNr;
    private double length;

    public Ride(int day, int rideNr, double length) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("The number of days should be between 1 and 7.");
        }
        if (rideNr < 1) {
            throw new IllegalArgumentException("The number of ride must be at least 1.");
        }
        if (!(length > 0)) {
            throw new IllegalArgumentException("The length is wrong.");
        }

        this.day = day;
        this.rideNr = rideNr;
        this.length = length;
    }

    public int getDay() {
        return day;
    }

    public int getRideNr() {
        return rideNr;
    }

    public double getLength() {
        return length;
    }
}