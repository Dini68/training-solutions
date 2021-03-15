package _aaa.exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;

    private LocalDate sailing;

    private double basicPrice;

    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (getPassengers().size() < getBoat().getMaxPassengers()) {
            this.passengers.add(passenger);
        }
        else {
            throw new IllegalArgumentException("no free space.");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        double multiplierForCruiseClass = passenger.getCruiseClass().getMultiplier();
        return getBasicPrice() * multiplierForCruiseClass;
    }

    public Passenger findPassengerByName(String name) {
        Passenger result;
        for (Passenger p: getPassengers()) {
            if (p. getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("no such name among passengers.");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> sortedList = new ArrayList<>();
        for (Passenger p: getPassengers()) {
            sortedList.add(p.getName());
        }
        Collections.sort(sortedList);
        return sortedList;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger p: getPassengers()) {
            sum += getPriceForPassenger(p);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger p: getPassengers()) {
            if (!result.containsKey(p.getCruiseClass())) {
                result.put(p.getCruiseClass(), 1);
            }
            else {
                result.put(p.getCruiseClass(), result.get(p.getCruiseClass()) + 1);
            }
        }
        return result;
    }
}
