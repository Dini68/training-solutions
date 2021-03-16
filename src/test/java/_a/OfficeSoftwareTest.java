package _a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {

    OfficeSoftware officeSoftware = new OfficeSoftware("ktm", 50000);
    DeveloperSoftware developerSoftware = new DeveloperSoftware("bcg", 80000);

    @Test
    void increasePriceWithOffice() {
        officeSoftware.increasePrice();
        assertEquals(52500, officeSoftware.getPrice());

    }
    @Test
    void increasePriceWithDeveloper() {
        developerSoftware.increasePrice();
        assertEquals(88000, developerSoftware.getPrice());

    }



}