package week13d02.junior;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {
    Airplane ap = new Airplane();

    @Test
    void moreDirectionTest() {
        ap.readFromFile("cities.txt");
        assertEquals(FlightDirection.DEPARTURE,ap.moreDirection());
    }

    @Test
    void foundFlight() {
        ap.readFromFile("cities.txt");
        assertEquals("Amsterdam", ap.foundFlight("ID4963").getCity());
        assertEquals(FlightDirection.DEPARTURE, ap.foundFlight("ID4963").getDirection());
        assertEquals(LocalTime.of(15,22), ap.foundFlight("ID4963").getTime());
    }

    @Test
    void findFlightByCity() {
        ap.readFromFile("cities.txt");
        System.out.println(ap.findFlightByCity("Toronto", FlightDirection.DEPARTURE));
    }

    @Test
    void earlierDepartingFlight() {
        ap.readFromFile("cities.txt");
        assertEquals("FG3210", ap.earlierDepartingFlight().getId());
        assertEquals(FlightDirection.DEPARTURE, ap.earlierDepartingFlight().getDirection());
        assertEquals("Zurich", ap.earlierDepartingFlight().getCity());
        assertEquals(LocalTime.of(6,16), ap.earlierDepartingFlight().getTime());
    }

    @Test
    void readFromFile() {
        ap.readFromFile("cities.txt");
        assertEquals(100,ap.getFlights().size());
    }
}
