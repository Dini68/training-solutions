package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;

        try{
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect!", sqlException);
        }
        Activity activity = new Activity(LocalDateTime.of(2021,02,23,10,11), "Biking in Zemplén", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021,02,23,10,11), "Hiking in Zemplén", ActivityType.HIKING);
        Activity activity3 = new Activity(LocalDateTime.of(2021,02,23,10,11), "Running in Zemplén", ActivityType.RUNNING);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(dataSource);

//        System.out.println(activityDao.selectById(4));
//        System.out.println(activityDao.selectAllActivities());
//        System.out.println(activityDao.selectActivitiesByType(ActivityType.BIKING));
    }
}
