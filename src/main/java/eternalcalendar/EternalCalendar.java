package eternalcalendar;

import java.time.LocalDate;
import java.util.Scanner;

public class EternalCalendar {

    private int year;
    private int month;
    private int day;

    private void dataAudit(int year, int month, int day) {
        if (year < 1) {
            throw new IllegalArgumentException("Az évnek minimum 1-nek kell lennie!");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("A hónapnak 1 és 12 közé kell esnie.");
        }
        if (day < 0 || day > 31) {
            throw new IllegalArgumentException("Hibás nap megadás!");
        }
    }


    public EternalCalendar(int year, int month, int day) {
        dataAudit(year,month,day);
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

    public String whichDayOfTheWeek () {
        String whichDay = "";
        switch (howManyDaysSince() % 7) {
            case 1 :
                whichDay = "hétfőn.";
                break;
            case 2 :
                whichDay = "kedden.";
                break;
            case 3 :
                whichDay = "szerdán.";
                break;
            case 4 :
                whichDay = "csütörtökön.";
                break;
            case 5 :
                whichDay = "pénteken.";
                break;
            case 6 :
                whichDay = "szombaton.";
                break;
            case 0 :
                whichDay = "vasárnap.";
                break;
        }
        return whichDay;
    }

    public int howManyDaysSince(){
        int howManyDays = 0;
        howManyDays = (year - 1) * 365
                + (year - 1) / 4
                + (year - 1) / 400
                - (year - 1) / 100
                + (month + 7) / 10 * ( (4   - year % 4  ) / 4
                + (400 - year % 400) / 400
                - (100 - year % 100) / 100 )
                + (month - 1) * 30
                + (month / 9 + month) / 2
                - (month + 7) / 10 * 2
                + day;
        return howManyDays;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

/*        System.out.print("Kérem a nevet: ");
        String name = scanner.nextLine();
*/
        System.out.println("\nKérem a születési dátumot!\n");
        System.out.print("Év: ");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Hónap: ");
        int monthOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nap: ");
        int dayOfBirth = scanner.nextInt();
        scanner.nextLine();

        EternalCalendar birthday = new EternalCalendar(yearOfBirth, monthOfBirth, dayOfBirth);
        EternalCalendar today = new EternalCalendar(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());

        int numberOfDaysToBirthday = birthday.howManyDaysSince();
        int numberOfDaysToNow = today.howManyDaysSince();

        System.out.print("\nAz Úr " + birthday.howManyDaysSince() + ". napján születtél, ");
        System.out.println(birthday.whichDayOfTheWeek());

        String daysToNow = numberOfDaysToNow - numberOfDaysToBirthday + " napot éltél idáig.";

        EternalCalendar birthdayInThisYear = new EternalCalendar(today.getYear(), birthday.getMonth(),
                birthday.getDay());
        EternalCalendar birthdayInNextYear = new EternalCalendar(today.getYear() + 1, birthday.getMonth(),
                birthday.getDay());

        int daysToNextBirthday = 0;

        if (birthdayInThisYear.howManyDaysSince() <= today.howManyDaysSince()) {
            daysToNextBirthday = birthdayInNextYear.howManyDaysSince() - today.howManyDaysSince();
            System.out.println(today.getYear() - birthday.getYear() + " éves vagy, " + daysToNow);
        } else {
            daysToNextBirthday = birthdayInThisYear.howManyDaysSince() - today.howManyDaysSince();
            System.out.println(today.getYear() - birthday.getYear() - 1 + " éves vagy, " + daysToNow);
        }
        if (birthdayInThisYear.howManyDaysSince() == today.howManyDaysSince()) {
            System.out.println("Boldog Születésnapot!");
        } else {
            System.out.println("A következő születésnapodig " + daysToNextBirthday + " nap van hátra.");
        }
    }
}
