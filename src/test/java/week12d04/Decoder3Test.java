package week12d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Decoder3Test {

    @Test
    void binaryFileDecoderTest() {
        Decoder3 en = new Decoder3();
        System.out.println(en.binaryFileDecoder("secret.dat"));
        assertEquals(100, en.getBufferSize().get(0));
        assertEquals(26, en.getBufferSize().get(1));
    }
}