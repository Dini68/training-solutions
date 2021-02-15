package exam03;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Cruise {

    private Boat boat;

    private LocalDate sailling;

    private double basicPrice;

    private List<Passenger> passengers;

    public Cruise(Boat boat, LocalDate sailling, double basicPrice) {
        this.boat = boat;
        this.sailling = sailling;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {

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

}
