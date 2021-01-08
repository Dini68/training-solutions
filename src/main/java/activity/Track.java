package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate () {
        return new Coordinate(1,1);
    }

    public Coordinate findMinimumCoordinate () {
        return new Coordinate(1,1);
    }

    public double getDistance() {
        return 1;
    }

    public double getFullDecrease() {
        return 1;
    }

    public double getFullElevation() {
        return 1;
    }

    public double GetRectangleArea() {
        return 1;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
