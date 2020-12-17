package methodoverloading;

import java.time.LocalTime;

public class Time {

    private int hours;

    private int minutes;

    private int seconds;

    private Time time;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public Time getTime() {
        return time;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public boolean isEqual(Time time) {
        return (this.hours == time.hours) && (this.minutes == time.minutes) && (this.seconds == time.seconds);
    }
    public boolean isEqual(int hours, int minutes, int seconds) {
        return (this.hours == hours) && (this.minutes == minutes) && (this.seconds == seconds);
    }
    public boolean isEarlier(Time time) {
        return LocalTime.of(this.hours,this.minutes,this.seconds).isBefore(LocalTime.of(time.hours,time.minutes,time.seconds));
    }
    public boolean isEarlier(int hours, int minutes, int seconds) {
        return LocalTime.of(this.hours,this.minutes,this.seconds).isBefore(LocalTime.of(hours,minutes,seconds));
    }
}
