package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
    public void init(){
        MariaDbDataSource dataSource;

        try{
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        }
        catch (
                SQLException sqlException) {
            throw new IllegalStateException("Cannot connect!", sqlException);
        }
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void insertActivityTest() {
        Activity activity = activityDao.findById(1L);

        assertEquals(ActivityType.BIKING, activity.getActivityType());
    }

    @Test
    public void selectBeforeDateTest() {
        System.out.println(activityDao.selectActivitiesBeforeDate(LocalDate.of(2020, 2, 1)));
    }

    @Test
    public void findByIdTest() {
        Activity activity = new Activity(LocalDateTime.of(2021,02,15,15,00), "Basketball in park", ActivityType.BASKETBALL);
        Activity result = activityDao.insertActivity(activity);

        assertEquals("Basketball in park", activityDao.findById(result.getId()).getDesc());
    }

    @Test
    public void insertActivityWithTrackPointsTest() {
        Activity activity = new Activity(LocalDateTime.of(2021,03,15,15,00), "Biking in Zemplén", ActivityType.BIKING);
        activity.addTrackPoints(List.of(
                new TrackPoint(LocalDate.of(2021, 02, 23), 67, 23),
                new TrackPoint(LocalDate.of(2021, 02, 23), 68, 22),
                new TrackPoint(LocalDate.of(2021, 02, 23), 67, 21)));
        Activity ac = activityDao.insertActivity(activity);
        System.out.println(activityDao.findById(ac.getId()));
    }



}