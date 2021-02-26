package exam03retake02;

public class Station {

    private int id;
    private String name;
    private String lat;
    private String lng;
    private String description;
    private int level;
    private String groupId;
    private String stationType;

    public Station(int id, String name, String lat, String lng, String description, int level, String groupId, String stationType) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.description = description;
        this.level = level;
        this.groupId = groupId;
        this.stationType = stationType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getStationType() {
        return stationType;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", groupId='" + groupId + '\'' +
                ", stationType='" + stationType + '\'' +
                '}';
    }
}
