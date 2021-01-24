package exceptionclass;

public class SimpleTime {

    private int hour;

    private  int minute;

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null", 0);
        }
        try {
            int hour = Integer.parseInt(time.split(":")[0]);
            if (hour < 0 || hour > 23) {
                throw new InvalidTimeException("Hour is invalid (0-23)", hour);
            }
            int minute = Integer.parseInt(time.split(":")[1]);
            if (minute < 0 || minute > 59) {
                throw new InvalidTimeException("Minute is invalid (0-59)", minute);
            }
            this.hour = hour;
            this.minute = minute;
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm", 1);
        }
        if (!(String.format("%02d:%02d", hour, minute).equals(time))) {
            throw new InvalidTimeException("Time is not hh:mm", 0);
        }
    }

    public SimpleTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)", hour);
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)", minute);
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour , minute);
    }

    public static void main(String[] args) {
        SimpleTime st = new SimpleTime("aa");
        System.out.println(st.toString());
        SimpleTime st2 = new SimpleTime(5, 84);
        System.out.println(st2.toString());
    }
}
