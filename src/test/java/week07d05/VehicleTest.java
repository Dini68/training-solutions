package week07d05;

import org.junit.jupiter.api.Test;
import week07d04.Lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VehicleTest {

    @Test
    public void createVehicleTest(){
        Vehicle vehicle = new Vehicle();

        assertEquals(5, vehicle.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, vehicle.getTransmissionType());
    }

}
