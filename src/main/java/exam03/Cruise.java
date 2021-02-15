package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        passengers.add(passenger);

    }
    public double getPriceForPassenger(Passenger passenger) {
        return 0.0;
    }

    public Passenger findPassengerByName(String name) {
        return null;
    }

    public List<String> getPassengerNamesOrdered() {
        return null;
    }

    public double sumAllBookingsCharged() {
        return 0.0;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        return null;
    }

    public static void main(String[] args) {
        Boat boat = new Boat("WetDreams", 5);

        Cruise cruise = new Cruise(boat, LocalDate.of(2021, 1, 1), 100_000);

        cruise.bookPassenger(new Passenger("John Doe", CruiseClass.LUXURY));

    }

}
