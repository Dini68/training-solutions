package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BiscuitTest {

    @Test
    public void biscuitOfTest() {
        assertEquals(200, Biscuit.of(BiscuitType.OREO,200).getGramAmount());
        assertEquals(BiscuitType.OREO, Biscuit.of(BiscuitType.OREO,200).getType());
    }
}
