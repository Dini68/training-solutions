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
        final int R = 6371; // Radius of the earth

        double lat1 = this.coordinate.getLatitude();
        double lat2 = trackPoint.coordinate.getLatitude();
        double latDistance = Math.toRadians(lat2 - lat1);

        double lon1 = this.coordinate.getLongitude();
        double lon2 = trackPoint.coordinate.getLongitude();
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c * 1000; // convert to meters

        double el1 = this.elevation;
        double el2 = trackPoint.getElevation();

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public double getElevation() {
        return elevation;
    }
}
