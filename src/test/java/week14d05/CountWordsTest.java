package week14d05;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {

    @Test
    void main() {
        CountWords cw = new CountWords();
        Map <String, Integer> result = new HashMap<>();
        result = cw.countWords("hachiko.srt", "Hachiko",
                "haza", "pályaudvar", "jó");
        assertEquals(16, result.get("haza"));
        assertEquals(38, result.get("jó"));
    }
}