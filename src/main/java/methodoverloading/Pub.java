package methodoverloading;

public class Pub {

    private String name;

    private Time openFrom;

    public Time getOpenFrom() {
        return openFrom;
    }

    public String getName() {
        return name;
    }

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.openFrom = new Time(hours, minutes);
    }

    @Override
    public String toString() {
        return name + ";" + openFrom.getHours() + ":" + openFrom.getMinutes();
    }

}
