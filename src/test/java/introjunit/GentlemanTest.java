package introjunit;

import org.junit.Assert;
import org.junit.Test;

public class GentlemanTest {

    @Test
    public void testCreate() {

        Gentleman gentleman = new Gentleman();

        gentleman.sayHello("Dennis");
    }
}
