package inheritanceconstructor.coursefacility;

public class Course {

    private int participants;

    private Facility facilityNeeded;

    public int getParticipants() {
        return participants;
    }

    public Facility getFacilityNeeded() {
        return facilityNeeded;
    }

    public Course(int participants, Facility facilityNeeded) {
        this.participants = participants;
        this.facilityNeeded = facilityNeeded;
    }
}
