package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MotorcycleTest {

    @Test
    public void createMotorcycleTest(){
        Motorcycle motorcycle = new Motorcycle(7);

        assertEquals(7, motorcycle.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
    }

}
