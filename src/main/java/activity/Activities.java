package activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = new ArrayList<>(activities);
    }

    public void addActivity (Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> result = new ArrayList<>();
        double distance;
        for (int j = 0; j < ActivityType.values().length; j++) {
            distance = 0;
            for (Activity ac : activities) {
                if (ac.getType() == ActivityType.values()[j]) {
                    distance += ac.getDistance();
                }
            }
            result.add(new Report(ActivityType.values()[j], distance));
        }
        return result;
    }

    public int numberOfTrackActivities() {
        int numberOfTrackActivities = 0;
        for (Activity ac : activities) {
            if (ac instanceof ActivityWithTrack) {
                numberOfTrackActivities ++;
            }
        }
        return numberOfTrackActivities;
    }

    public int numberOfWithoutTrackActivities() {
        int numberOfWithoutTrackActivities = 0;
        for (Activity ac : activities) {
            if (ac instanceof ActivityWithoutTrack) {
                numberOfWithoutTrackActivities ++;
            }
        }
        return numberOfWithoutTrackActivities;
    }
}
