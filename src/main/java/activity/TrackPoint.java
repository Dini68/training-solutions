package activity;

public class TrackPoint {

    private Coordinate coordinate;

    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getDistanceFrom(TrackPoint trackPoint) {
        double x = this.coordinate.getLatitude() - trackPoint.getCoordinate().getLatitude();
        double y = this.coordinate.getLongitude() - trackPoint.getCoordinate().getLongitude();
        double z = this.elevation - trackPoint.getElevation();
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getElevation() {
        return elevation;
    }
}
