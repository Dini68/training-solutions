package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    private Day nextDay(Day day) {
        Day nextday;
        if (day.ordinal() == Day.values().length - 1) {
            nextday = Day.values()[0];
        } else {
            nextday = Day.values()[day.ordinal() + 1];
        }
        return nextday;
    }

    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        List<DayType> dayTypeList = new ArrayList<>();
        Day  d = firstDay;
        for (int i = 0; i < numberOfDays; i++){
            dayTypeList.add(d.getDayType());
            d = nextDay(d);
        }
        return dayTypeList;
    }
}
