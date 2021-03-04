package __project;

import activitytracker.Activity;

import javax.sql.DataSource;
import java.sql.*;

public class CitizenDao {

    private DataSource dataSource;

    public CitizenDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void insertCitizen(Citizen citizen) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO citizens (citizen_name, zip, age, email, taj, number_of_vaccination, " +
                             "last_vaccination) values (?,?,?,?,?,?,?)",
                                Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, citizen.getFullName());
            stmt.setString(2, citizen.getZip());
            stmt.setLong(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getSocialSecurityNumber());
            stmt.setLong(6, 0);
//            stmt.setTimestamp(7, Timestamp.valueOf("0"));
            stmt.setTimestamp(7, Timestamp.valueOf("2021-03-01 12:00:00"));
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }
    }
}
//    public  Activity insertActivity(Activity activity) {
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(
//                     "insert into activities(start_time, activity_desc, activity_type) values (?,?,?)",
//                     Statement.RETURN_GENERATED_KEYS)) {
//            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
//            stmt.setString(2, activity.getDesc());
//            stmt.setString(3,activity.getType().toString());
//            stmt.executeUpdate();
//            Activity result = getIdAfterExecuted(activity, stmt);
//            insertActivityTrackPoints(activity.getTrackPoints(),result.getId());
//
//            return result;
//
//        } catch (SQLException sqlException) {
//            throw new IllegalStateException("Cannot connect", sqlException);
//        }
//    }

//        MariaDbDataSource dataSource = new MariaDbDataSource();
//        try {
//            dataSource.setUrl("jdbc:mariadb://localhost:3306/ClosingProject?useUnicode=true");
//            dataSource.setUser("alma");
//            dataSource.setPassword("alma");
//        } catch (SQLException se) {
//            throw new IllegalArgumentException("Some problem with dataSource", se);
//        }
//        try (BufferedReader bf = Files.newBufferedReader(Path.of("zipcodes.csv"))) {
//            String line;
//            bf.readLine();
//            while ((line = bf.readLine()) != null) {
//                String[] data = line.split(";");
//                try (Connection conn = dataSource.getConnection();
//                     PreparedStatement stmt = conn.prepareStatement("insert into zipcodes(zip, city, district) values (?, ?, ?)")) {
//                    if (data.length == 3) {
//                        stmt.setString(1, data[0]);
//                        stmt.setString(2, data[1]);
//                        stmt.setString(3, data[2]);
//                        stmt.executeUpdate();
//                    } else {
//                        stmt.setString(1, data[0]);
//                        stmt.setString(2, data[1]);
//                        stmt.setString(3, null);
//                        stmt.executeUpdate();
//                    }
//                } catch (SQLException se) {
//                    throw new IllegalArgumentException("Something went wrong during writing database");
//                }
//            }
//        } catch (IOException ioe) {
//            throw new IllegalArgumentException("Something went wrong during reading file!");
//        }
