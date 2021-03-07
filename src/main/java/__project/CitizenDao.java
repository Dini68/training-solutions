package __project;

import activitytracker.Activity;
import activitytracker.TrackPoint;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void insertVaccination() {

        List<Vaccination> vaccinations = new ArrayList<>();
        vaccinations = selectByNumVac1();
        System.out.println(vaccinations.size());
        System.out.println(vaccinations);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO vaccinations (citizen_id, vaccination_date, status, note, vaccination_type) values (?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS)) {
//                     "INSERT INTO citizens (citizen_name, zip, age, email, taj, " +
//                             "number_of_vaccination, last_vaccination) values (?,?,?,?,?,?,?)",
//                                 Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < vaccinations.size(); i++) {
                stmt.setLong(1, vaccinations.get(i).getCitizen_id());
                stmt.setTimestamp(2, vaccinations.get(i).getVaccination_date());
                stmt.setString(3, vaccinations.get(i).getStatus());
                stmt.setString(4, vaccinations.get(i).getNote());
                stmt.setString(5, vaccinations.get(i).getVaccination_type());
                stmt.executeUpdate();

            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }
    }

    public void insertVaccination(Vaccination vaccination) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO vaccinations (citizen_id, vaccination_date, status, note, vaccination_type) values (?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS)) {
                stmt.setLong(1, vaccination.getCitizen_id());
                stmt.setTimestamp(2, vaccination.getVaccination_date());
                stmt.setString(3, vaccination.getStatus());
                stmt.setString(4, vaccination.getNote());
                stmt.setString(5, vaccination.getVaccination_type());
                stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }
    }

    public void updateVaccination(Vaccination vaccination) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE vaccinations SET vaccination_date = ?, status = ?, note = ?, vaccination_type = ? WHERE citizen_id = ?",
                                Statement.RETURN_GENERATED_KEYS)) {
                stmt.setTimestamp(1, vaccination.getVaccination_date());
                stmt.setString(2, vaccination.getStatus());
                stmt.setString(3, vaccination.getNote());
                stmt.setString(4, vaccination.getVaccination_type());
                stmt.setLong(5, vaccination.getCitizen_id());
                stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not update", se);
        }
    }

    public List<String> selectCityByZip(String zip) {
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

    public int getNumVacBySsn(String ssn) {
        int numVac = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement( "SELECT number_of_vaccination FROM citizens WHERE taj = ?")){

            ps.setString(1, ssn);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    numVac = rs.getInt("number_of_vaccination");
                    return numVac;
                }
            }
            throw new IllegalArgumentException("Nincs ilyen TAJ szám a regisztráltak között");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }
    public int getIdBySsn(String ssn) {
        int id = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement( "SELECT citizen_id FROM citizens WHERE taj = ?")){

            ps.setString(1, ssn);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("citizen_id");
                    return id;
                }
            }
            throw new IllegalArgumentException("Nincs ilyen TAJ szám a regisztráltak között");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    public int countVaccination(int id) {
        int count = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement( "SELECT note FROM vaccinations WHERE citizen_id = ?")){

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    count++;
                }
            }
            return count;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    public List<Vaccination> selectByNumVac1() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens WHERE number_of_vaccination = 1")){

//            ps.setString(1, zip);
            try (ResultSet rs = ps.executeQuery()) {
                List<Vaccination> vaccinations = new ArrayList<>();
                String status = "1";
                String note = "Első oltás beadva";
                Random rnd = new Random();
                String vacType;
                while (rs.next()) {
                    int id = rs.getInt("citizen_id");
                    Timestamp vacDate = rs.getTimestamp("last_vaccination");
                    vacDate = Timestamp.valueOf(vacDate.toLocalDateTime().plusDays(rnd.nextInt(20)));
                    vacType = VaccineType.values()[rnd.nextInt(5)].toString();
                    vaccinations.add(new Vaccination(id, vacDate, status, note, vacType));
                }
                return vaccinations;
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    public List<String> selectByZipAndAge(String zip, LocalDateTime vacDate) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens " +
                     "WHERE zip = ? " +
                     "AND (number_of_vaccination = 0 " +
                     "OR  (`number_of_vaccination` = 1 AND ADDDATE(`last_vaccination`, 15) < ?))" +
                     "ORDER BY `age` DESC, `citizen_name` LIMIT 16")){
//             PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizens WHERE zip = ? ORDER BY age DESC LIMIT 16")){

            ps.setString(1, zip);
//            ps.setDate(2, 2021-02-15);
            ps.setTimestamp(2, Timestamp.valueOf(vacDate));

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
