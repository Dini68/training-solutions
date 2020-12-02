package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class WordEraserTest {

    WordEraser wordEraser = new WordEraser();
    String s;

    @Test
    public void eraserWordkörteTest() {
        s = wordEraser.eraseWord("alma körte villa körte kanál", "körte");
        assertEquals("alma villa kanál", s);
    }
    @Test
    public void eraserWordalmaTest() {
        s = wordEraser.eraseWord("alma körte villa körte kanál", "alma");
        assertEquals("körte villa körte kanál", s);
    }
    @Test
    public void eraserWordspaceTest() {
        s = wordEraser.eraseWord("alma körte villa körte kanál", "");
        assertEquals("alma körte villa körte kanál", s);
    }
    @Test
    public void eraserWordbirsalmaTest() {
        s = wordEraser.eraseWord("alma körte villa körte kanál birsalma", "alma");
        assertEquals("körte villa körte kanál birsalma", s);
    }
}
