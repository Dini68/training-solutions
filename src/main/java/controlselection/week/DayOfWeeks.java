package controlselection.week;

public class DayOfWeeks {

    public String whichDay (String nameOfWeek) {
        String day = "";
        switch (nameOfWeek.toLowerCase()) {
            case "hétfő":
                day = "hét eleje";
                break;
            case "kedd":
            case "szerda":
            case "csütörtök":
                day = "hét közepe";
                break;
            case "péntek":
                day = "majdnem hétvége";
                break;
            case "szombat":
            case "vasárnap":
                day = "hét vége";
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
        return day;
    }

    public static void main(String[] args) {
        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        System.out.println(dayOfWeeks.whichDay("Hétfő"));
        System.out.println(dayOfWeeks.whichDay("Szerda"));
        System.out.println(dayOfWeeks.whichDay("Péntek"));
        System.out.println(dayOfWeeks.whichDay("Szombat"));
        System.out.println(dayOfWeeks.whichDay("Vasárnap"));
    }
}
