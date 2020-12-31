package week08d01.senior;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SultanTest {

    @Test
    public void openDoorsTest() {

        Sultan sultan = new Sultan();
        assertEquals(true,sultan.openDoors(100)[0]);
        assertEquals(true,sultan.openDoors(100)[3]);
        assertEquals(true,sultan.openDoors(100)[80]);
        assertEquals(true,sultan.openDoors(200)[120]);
        assertEquals(true,sultan.openDoors(200)[195]);

        assertEquals(false,sultan.openDoors(100)[1]);
        assertEquals(false,sultan.openDoors(100)[13]);
        assertEquals(false,sultan.openDoors(100)[83]);
        assertEquals(false,sultan.openDoors(200)[112]);
        assertEquals(false,sultan.openDoors(200)[198]);
    }
}
