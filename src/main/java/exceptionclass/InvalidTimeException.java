package exceptionclass;

public class InvalidTimeException extends RuntimeException{

    private int hour;

    private int minute;

    public InvalidTimeException(String message, int minute) {
        super(message);
        this.minute = minute;
    }

    public InvalidTimeException(int hour) {
        this.hour = hour;
    }
}
