package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public  void insertActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?,?,?)")) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3,activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    public Activity selectById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?")){
            stmt.setLong(1, id);
            List<Activity> result = selectByPreparesStatement(stmt);
            if (result.size() == 1) {
                return result.get(0);

            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect", sqlException);
        }
    }

    private List<Activity> selectByPreparesStatement(PreparedStatement stmt) throws SQLException {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                Activity activity = new Activity(rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf((rs.getString("activity_type"))));
                result.add(activity);
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Wrong statement", sqlException);
        }
    }

    public List<Activity> selectAllActivities() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities")) {

            return selectByPreparesStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalArgumentException("Connection failed", sqlException);
        }
    }

    public List<Activity> selectActivitiesByType(ActivityType type) {

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from activities where activity_type = ?")){
            stmt.setString(1, type.toString());
            return selectByPreparesStatement(stmt);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!");
        }
    }

}
