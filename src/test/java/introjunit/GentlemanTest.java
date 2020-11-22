package introjunit;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {

    @Test
    public void testsayHello() {
        assertThat(new Gentleman().sayHello("Hunor"), equalTo("Hello Hunor"));
    }
}
