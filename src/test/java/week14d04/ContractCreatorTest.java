package week14d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    @Test
    void createTemplateTest() {
        ContractCreator cc = new ContractCreator("John Doe", new ArrayList<>(List.of(10, 20, 30, 40)));
        assertEquals("John Doe", cc.getTemplate().getClient());
        assertEquals(4, cc.getTemplate().getMonthlyPrices().size());
        assertEquals(30, cc.getTemplate().getMonthlyPrices().get(2));
    }
    @Test
    void createNewClientTest() {
        ContractCreator cc = new ContractCreator("John Doe", new ArrayList<>(List.of(10, 20, 30, 40)));
        Contract john = cc.create("Jack Doe");
        john.getMonthlyPrices().set(2, 20);
        assertEquals("Jack Doe", john.getClient());
        assertEquals(20, john.getMonthlyPrices().get(2));

        assertEquals(4, cc.getTemplate().getMonthlyPrices().size());
        assertEquals(30, cc.getTemplate().getMonthlyPrices().get(2));
    }
}