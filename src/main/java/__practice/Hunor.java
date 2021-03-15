package __practice;

import java.time.LocalDate;
import java.util.Random;

public class Hunor {

    public void eveningRoutine () {
        LocalDate date = LocalDate.of(2020,12,31);
        LocalDate date2 = LocalDate.now();
        int day = 0;
        while (!date.plusDays(day).equals(date2)) {
            day++;
        }
        System.out.print("Hunor ma esti rutinja: ");
        switch (day % 3) {
            case 0 :
                System.out.println("fürdés");
                break;
            case 1 :
                System.out.println("zuhanyzás");
                break;
            default :
                System.out.println("átöltözés");
        }
    }

    public void multiple2digits() {
        Random rnd = new Random();
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10; i++) {
            a = rnd.nextInt(900) + 100;
            b = rnd.nextInt(90) + 10;
            System.out.println(a + " * " + b + " = " + (a * b));
        }
    }

    public static  void main(String[] args) {
        Hunor hunor = new Hunor();
        hunor.multiple2digits();
        hunor.eveningRoutine();
    }
}
