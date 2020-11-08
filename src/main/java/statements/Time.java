package statements;

public class Time {

    private int hour;

    private int minute;

    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getInMinutes() {
        return hour * 60 + minute;
    }

    public int getInSeconds() {
        return hour * 3600 + minute * 60 + second;
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public Boolean aerlierThan(Time time1, Time time2) {
        return time1.getInSeconds() < time2.getInSeconds();
    }
}
