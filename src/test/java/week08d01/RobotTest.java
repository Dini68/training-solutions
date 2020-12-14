package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    public void moveTest() {
        Robot robot = new Robot();
        robot.move("FFLLLLLBBBBJJJJJJJ");
        assertEquals(3,robot.getPosition().getX());
        assertEquals(-3,robot.getPosition().getY());
    }

    @Test
    public void wrongMoveTest() {
        Robot robot = new Robot();
        assertThrows(IllegalArgumentException.class, ()-> robot.move("FFLLLLLBBBBJJJKJJJ"));
    }
}
