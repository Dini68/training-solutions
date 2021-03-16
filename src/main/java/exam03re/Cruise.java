package exam03re;

import _toto.ppp.A;

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
        return new ArrayList<>(passengers);
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "boat=" + boat +
                ", sailing=" + sailing +
                ", basicPrice=" + basicPrice +
                ", passengers=" + passengers +
                '}';
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        }
        else {
            throw new IllegalArgumentException("Nincs több hely a hajón");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().getMultiple();
     }

    public Passenger findPassengerByName(String name) {
        for (Passenger p: passengers) {
            if (p.getName().equals(name)) {
               return p;
            }
        }
        throw new IllegalArgumentException("nincs ilyen név az utasok között");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> result = new ArrayList<>();
        for (Passenger p: passengers) {
            result.add(p.getName());
        }
        Collections.sort(result);
        return result;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger p: passengers) {
            sum += getPriceForPassenger(p);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for(Passenger p: passengers) {
            if (result.containsKey(p.getCruiseClass())) {
                result.put(p.getCruiseClass(), result.get(p.getCruiseClass()) + 1);
            }
            else {
                result.put(p.getCruiseClass(), 1);
            }
        }
        return result;
    }
}
