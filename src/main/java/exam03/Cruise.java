package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;

    private LocalDate sailing;

    private double basicPrice;

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
        }

    }
    public double getPriceForPassenger(Passenger passenger) {
        double multipler = 1.0;
        if (passenger.getCruiseClass() == CruiseClass.LUXURY) {
            multipler = 3.0;
        }
        if (passenger.getCruiseClass() == CruiseClass.FIRST) {
            multipler = 1.8;
        }
        return getBasicPrice() * multipler;
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger p: passengers) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("not such name");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> sortedNames = new ArrayList<>();
        for (Passenger p: passengers) {
            sortedNames.add(p.getName());
        }
        Collections.sort(sortedNames);
        return sortedNames;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger p: passengers) {
            if (p.getCruiseClass() == CruiseClass.LUXURY) {
                sum += getBasicPrice() * 3.0;
            }
            if (p.getCruiseClass() == CruiseClass.FIRST) {
                sum += getBasicPrice() * 1.8;
            }
            if (p.getCruiseClass() == CruiseClass.SECOND) {
                sum += getBasicPrice() * 1.0;
            }
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger p: passengers) {
            if (!result.containsKey(p.getCruiseClass())) {
                result.put(p.getCruiseClass(), 1);
            }
            else {
                result.put(p.getCruiseClass(), result.get(p.getCruiseClass()) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Boat boat = new Boat("WetDreams", 5);

        Cruise cruise = new Cruise(boat, LocalDate.of(2021, 1, 1), 100_000);

        cruise.bookPassenger(new Passenger("John Doe", CruiseClass.LUXURY));
        for (int i = 0; i < 5; i++) {
            cruise.bookPassenger(new Passenger("John Doe", CruiseClass.LUXURY));
        }

    }

}
