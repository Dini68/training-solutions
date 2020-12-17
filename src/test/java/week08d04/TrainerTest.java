package week08d04;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TrainerTest {

    @Test
    public void giveMarkTest() {
        Trainer trainerGoodMood = new Trainer(new GoodMood());
        Trainer trainerBadMood = new Trainer(new BadMood());
        assertEquals(5, trainerGoodMood.giveMark());
        assertEquals(3, trainerBadMood.giveMark());
    }
}
