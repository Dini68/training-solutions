package __project;

import java.sql.Timestamp;

public class Vaccination {

    int citizen_id;
    Timestamp vaccination_date;
    String status;
    String note;
    String vaccination_type;

    public Vaccination(int citizen_id, Timestamp vaccination_date, String status, String note, String vaccination_type) {
        this.citizen_id = citizen_id;
        this.vaccination_date = vaccination_date;
        this.status = status;
        this.note = note;
        this.vaccination_type = vaccination_type;
    }

    public int getCitizen_id() {
        return citizen_id;
    }

    public Timestamp getVaccination_date() {
        return vaccination_date;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public String getVaccination_type() {
        return vaccination_type;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "citizen_id=" + citizen_id +
                ", vaccination_date=" + vaccination_date +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", vaccination_type='" + vaccination_type + '\'' +
                '}';
    }
}
