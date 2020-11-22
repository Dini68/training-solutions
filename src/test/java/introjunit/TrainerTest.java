package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testCreate() {
        // Given
        Trainer trainer = new Trainer("Hunor");

        // When
        String name = trainer.getName();

        // Then
        assertEquals("Hunor",name);
    }
}
