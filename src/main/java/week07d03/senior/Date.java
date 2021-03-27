package week07d03.senior;

public class Date {

    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static Date of (int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, getMonth(), getDay());
    }

    public Date withMonth(int month) {
        return new Date(getYear(), month, getDay());
    }

    public Date withDay(int day) {
        return new Date(getYear(), getMonth(), day);
    }


}
