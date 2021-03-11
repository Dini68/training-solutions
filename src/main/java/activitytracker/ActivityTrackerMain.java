package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerMain {



    public static void main(String[] args) {
        MariaDbDataSource dataSource;


        try{
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        }
        catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connect!", sqlException);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(dataSource);

        activityDao.insertActivity(new Activity(LocalDateTime.of(2021,02,15,15,00), "Basketball in park", ActivityType.BASKETBALL));
        activityDao.insertActivity(new Activity(LocalDateTime.of(2021,02,15,15,00), "Biking in park", ActivityType.BIKING));
        System.out.println(activityDao.selectAllActivities());
        System.out.println(activityDao.selectByType(ActivityType.BIKING));



    }
}
