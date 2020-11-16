package array;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int [] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public String daysOfWeek() {
        List<String> days = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
        return days.toString();
    }
    public String multiplicationTableAsString(int size) {
        String valueString = "";
        for (int i = 1; i <= size; i++) {
            for (int j = 1;  j<= size; j++) {
                valueString = valueString + i*j + " ";
            }
        }
        return valueString;
    }

    public void sameTempValues(double[] day, double[] anotherDay) {
        System.out.println(day.length);
        System.out.println(anotherDay.length);
        boolean azonos = false;
        for (int i = 0; i < 24; i++) {
            if (day[i] == anotherDay[i]) {
                azonos = true;
            }
        }
        if (azonos) {
            System.out.println("Volt azonos mérés a két nap hőmérsékletei között!");
        }

    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println(arraysMain.daysOfWeek());
        System.out.println(arraysMain.multiplicationTableAsString(5));
        double [] day = {4, 3, 2, 3, 4, 5, 6, 6, 7, 7, 8, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 5};
        double [] anotherDay = {4, 3, 2, 3, 4, 5, 6, 6, 7, 7, 8, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 5};
        arraysMain.sameTempValues(day, anotherDay);
    }
}

