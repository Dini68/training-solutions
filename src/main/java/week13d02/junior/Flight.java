package week13d02.junior;

import java.time.LocalTime;

public class Flight {

    private String id;

    private FlightDirection direction;

    private String city;

    private LocalTime time;

    public Flight(String id, FlightDirection direction, String city, LocalTime time) {
        this.id = id;
        this.direction = direction;
        this.city = city;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public FlightDirection getDirection() {
        return direction;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", direction=" + direction +
                ", city='" + city + '\'' +
                ", time=" + time +
                '}';
    }
}
