package activity;

public class ActivityWithTrack implements Activity{

    private Track track;

    private ActivityType activityType;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        if (track == null) {
            throw new IllegalArgumentException("Rossz adat.");
        }
        if (activityType == null) {
            throw new IllegalArgumentException("Rossz adat.");
        }
        this.track = track;
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
