package exam03re;

public class Passenger {

    private String name;
    private CruiseClass cruiseClass;

    public Passenger(String name, CruiseClass cruiseClass) {
        this.name = name;
        this.cruiseClass = cruiseClass;
    }

    public String getName() {
        return name;
    }

    public CruiseClass getCruiseClass() {
        return cruiseClass;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", cruiseClass=" + cruiseClass +
                '}';
    }
}
