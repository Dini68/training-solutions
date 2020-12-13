package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TruckTest {
    @Test
    public void createTruckTest(){
        Truck truck = new Truck(4, TransmissionType.AUTOMATIC);

        assertEquals(4, truck.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, truck.getTransmissionType());
    }

    @Test
    public void createTruckTest2() {
        Truck truck = new Truck(8, TransmissionType.SEQUENTIAL);

        assertEquals(8, truck.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, truck.getTransmissionType());
    }
}
