package __project;

import activitytracker.Activity;
import activitytracker.TrackPoint;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                    System.out.println(city);
                }
                return cities;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

}
