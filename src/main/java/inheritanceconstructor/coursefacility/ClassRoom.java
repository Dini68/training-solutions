package inheritanceconstructor.coursefacility;

public class ClassRoom extends Room{

    private Facility facility;

    public Facility getFacility() {
        return facility;
    }

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }
    public boolean isSuitable(Course course) {
        return  (course.getFacilityNeeded() == facility && course.getParticipants() <= getCapacity());
    }

}
