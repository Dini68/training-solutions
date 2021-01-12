package week11d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void addRideWithNullTest() {
        Courier cu = new Courier();
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(null));
    }
    @Test
    void addRideWithErrorDayTest() {
        Courier cu = new Courier();
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(new Ride(0,1,34.5)));
    }
    @Test
    void addRideWithErrorDay2Test() {
        Courier cu = new Courier();
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(new Ride(8,1,34.5)));
    }
    @Test
    void addRideWithErrorDay3Test() {
        Courier cu = new Courier();
        Ride r1=new Ride(3,1,34.5);
        cu.addRide(r1);
        Ride r2=new Ride(2,1,34.5);
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(r2));
    }
    @Test
    void addRideWithErrorRideTest() {
        Courier cu = new Courier();
        Ride r1=new Ride(1,1,34.5);
        Ride r2=new Ride(2,1,34.5);
        Ride r3=new Ride(2,3,34.5);
        cu.addRide(r1);
        cu.addRide(r2);
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(r3));
    }
    @Test
    void addRideWithErrorRide3Test() {
        Courier cu = new Courier();
        Ride r1=new Ride(4,1,34.5);
        Ride r2=new Ride(4,2,34.5);
        Ride r3=new Ride(4,1,34.5);
        cu.addRide(r1);
        cu.addRide(r2);
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(r3));
    }
    @Test
    void addRideWithErrorRide2Test() {
        Courier cu = new Courier();
        Ride r1=new Ride(1,1,34.5);
        Ride r2=new Ride(2,1,34.5);
        cu.addRide(r1);
        cu.addRide(r2);
        assertThrows(IllegalArgumentException.class, () -> cu.addRide(new Ride(2,0,34.5)));
    }
    @Test
    void firstFreeDay1Test() {
        Courier cu = new Courier();
        Ride r1=new Ride(1,1,34.5);
        Ride r2=new Ride(2,1,34.5);
        Ride r3=new Ride(3,1,34.5);
        cu.addRide(r1);
        cu.addRide(r2);
        cu.addRide(r3);
        assertEquals(4, cu.firstFreeDay());
    }
    @Test
    void firstFreeDay2Test() {
        Courier cu = new Courier();
        Ride r1=new Ride(2,1,34.5);
        Ride r2=new Ride(2,2,34.5);
        Ride r3=new Ride(5,1,34.5);
        cu.addRide(r1);
        cu.addRide(r2);
        cu.addRide(r3);
        assertEquals(1, cu.firstFreeDay());
    }
}