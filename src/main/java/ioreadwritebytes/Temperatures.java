package ioreadwritebytes;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double yearAverage;
        double sum = 0;
        for (int i = 0; i < 365; i++) {
            sum += data[i];
        }
        yearAverage = Math.round(sum * 1000 / 365) / 1000.0;
        return yearAverage ;
    }

    public double getMonthAverage() {
        double monthAverage;
        double sum = 0;
        for (int i = 335; i < 365; i++) {
            sum += data[i];
        }
        monthAverage = Math.round(sum * 1000 / 30) / 1000.0;
        return monthAverage ;
    }
}
