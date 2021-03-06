package __project;

import activitytracker.Activity;
import activitytracker.TrackPoint;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CitizenDao {

    private DataSource dataSource;

    public CitizenDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void insertCitizen(Citizen citizen) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
//                     "INSERT INTO citizens (citizen_name, zip, age, email, taj, number_of_vaccination) values (?,?,?,?,?,?)",
//                                Statement.RETURN_GENERATED_KEYS)) {
                     "INSERT INTO citizens (citizen_name, zip, age, email, taj, " +
                             "number_of_vaccination, last_vaccination) values (?,?,?,?,?,?,?)",
                                 Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, citizen.getFullName());
            stmt.setString(2, citizen.getZip());
            stmt.setLong(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getSocialSecurityNumber());
            stmt.setLong(6, 0);
            stmt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }
    }

    public List<String> selectByZip(String zip) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT city, city_part FROM cities WHERE zip= ?")){

            ps.setString(1, zip);
            try (ResultSet rs = ps.executeQuery()) {
                List<String> cities = new ArrayList<>();
                String city = "";
                String city_part = "";
                while (rs.next()) {
                    city = rs.getString("city");
                    city_part = rs.getString("city_part");
                    if (!city_part.equals("")) {
                        city += ", " + city_part;
                    }
                    cities.add(city);
                }
                return cities;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    public List<String> selectByZipAndAge(String zip) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens WHERE zip = ? ORDER BY age DESC LIMIT 16")){

            ps.setString(1, zip);
            try (ResultSet rs = ps.executeQuery()) {
                List<String> names = new ArrayList<>();
                int hour = 8;
                int minute = 00;
                LocalTime time;
                String name;
                String zipcode;
                int age;
                String email;
                String ssn;
                int numVac = 0;
                Date lastVac;
                while (rs.next()) {
                    name = rs.getString("citizen_name");
                    zipcode = rs.getString("zip");
                    age = rs.getInt("age");
                    email = rs.getString("email");
                    ssn = rs.getString("taj");
                    time = LocalTime.of(hour, minute);
                    numVac = rs.getInt("number_of_vaccination");
                    lastVac = rs.getDate("last_vaccination");
                    names.add(time + ";" + name + ";" + zipcode + ";" + age + ";" + email
                            + ";" + ssn + ";" + numVac+ ";" + lastVac);
                    hour = hour + minute / 30;
                    minute = (minute + 30) % 60;
                }
                return names;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

}
