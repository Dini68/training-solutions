package controlselection.month;

public class DayInMonth {

    public int numberOfDays (int year, String month){
        int dayNumber = 0;
        switch (month.toLowerCase()){
            case "január" :
                dayNumber = 31;
                break;
            case "február" :
                dayNumber = 28;
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    dayNumber = 29;
                }
                break;
            case "március" :
                dayNumber = 31;
                break;
            case "április" :
                dayNumber = 30;
                break;
            case "május" :
                dayNumber = 31;
                break;
            case "június" :
                dayNumber = 30;
                break;
            case "július" :
                dayNumber = 31;
                break;
            case "augusztus" :
                dayNumber = 31;
                break;
            case "szeptember" :
                dayNumber = 30;
                break;
            case "október" :
                dayNumber = 31;
                break;
            case "november" :
                dayNumber = 30;
                break;
            case "december" :
                dayNumber = 31;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        System.out.println(year + " " + month + ": " + dayNumber + " napos hónap");
        return dayNumber;
    }

    public static void main(String[] args) {

        DayInMonth dayInMonth = new DayInMonth();

        dayInMonth.numberOfDays(1900, "február");
        dayInMonth.numberOfDays(2020, "Február");
        dayInMonth.numberOfDays(2000, "február");
        dayInMonth.numberOfDays(2021, "FEBRUÁR");

        dayInMonth.numberOfDays(1900, "április");
        dayInMonth.numberOfDays(2020, "December");
        dayInMonth.numberOfDays(2000, "Június");
        dayInMonth.numberOfDays(2021, "Januá");
    }

}
