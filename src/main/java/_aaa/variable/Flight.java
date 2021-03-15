package _aaa.variable;

import java.time.LocalTime;

public class Flight {

    private String id;
    private String destiantion;
    private String city;
    private LocalTime time;

    public Flight(String id, String destiantion, String city, LocalTime time) {
        this.id = id;
        this.destiantion = destiantion;
        this.city = city;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getDestiantion() {
        return destiantion;
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
                ", destiantion='" + destiantion + '\'' +
                ", city='" + city + '\'' +
                ", time=" + time +
                '}';
    }
}
