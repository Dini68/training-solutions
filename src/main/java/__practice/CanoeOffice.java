package __practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CanoeOffice {

    private List<CanoeRental> canoeRentals = new ArrayList<>();

    public List<CanoeRental> getCanoeRentals() {
        return new ArrayList<>(canoeRentals);
    }

    public void addRental(CanoeRental canoeRental) {
        canoeRentals.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name) {
        for (CanoeRental cr: getCanoeRentals()) {
            if (cr.getName().equals(name) && cr.getEndTime() == null) {
                return cr;
            }
        }
        throw new IllegalArgumentException("no such rental");
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        findRentalByName(name).setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental actual = findRentalByName(name);
        double price = 0;
        int hour = (int) Duration.between(actual.getStartTime(), endTime).toHours() + 1;
        if (actual.getCanoeType() == CanoeType.GREEN) {
            price = 5000 * 1.2 * hour;
        }
        if (actual.getCanoeType() == CanoeType.BLUE) {
            price = 5000 * 1.5 * hour;
        }
        if (actual.getCanoeType() == CanoeType.RED) {
            price = 5000 * 1.0 * hour;
        }
        return price;
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> result = new ArrayList<>(getCanoeRentals());
        Collections.sort(result);
        return result;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> result = new HashMap<>();
        for (CanoeRental cr: canoeRentals) {
            if (result.containsKey(cr.getCanoeType())) {
                result.put(cr.getCanoeType(), 1);
            }
            else {
                result.put(cr.getCanoeType(), result.get(cr.getCanoeType()) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LocalDateTime actual = LocalDateTime.of(2021, 02, 16, 21, 38);
        double hour = Duration.between(actual, LocalDateTime.now()).toHours();
        System.out.println(hour);

    }
}
