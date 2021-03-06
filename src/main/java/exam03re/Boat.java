package exam03re;

public class Boat {

    private String name;
    private int maxPassengers;

    public Boat(String name, int maxPassengers) {
        this.name = name;
        this.maxPassengers = maxPassengers;
    }

    public String getName() {
        return name;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                ", maxPassengers=" + maxPassengers +
                '}';
    }
}
