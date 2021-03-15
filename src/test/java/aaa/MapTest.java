package aaa;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class MapTest {

    @Test
    public void testMap() {
        Map<String, String> codes = new HashMap<>();
        assertEquals(true, codes.isEmpty());

        codes.put("200", "OK");
        codes.put("404", "Not found");
        System.out.println(codes);

        Map<String,String> expected = new HashMap<>();
        expected.put("200", "OK");
        expected.put("404", "Not found");

        assertEquals(true, expected.equals(codes));

        codes.put("404", "Not Found");
        System.out.println(codes);

        String s = codes.get("404");
        System.out.println(s);

        codes.put("304", "Not Modified");
        System.out.println(codes);

        codes.remove("304");
        System.out.println(codes);

        assertEquals(false, codes.containsKey("304"));
        assertEquals(true, codes.containsValue("OK"));

        System.out.println(codes.keySet());
        System.out.println(codes.values());

        System.out.println((codes.entrySet()));

        for (Map.Entry entries: codes.entrySet()) {
            System.out.println(entries.getKey());
            System.out.println(entries.getValue());

        }

    }
    @Test
    public void testMap2() {
        Map<String, String> codes = new LinkedHashMap<>();
        assertEquals(true, codes.isEmpty());

        codes.put("200", "OK");
        codes.put("404", "Not found");
        System.out.println(codes);

        Map<String,String> expected = new HashMap<>();
        expected.put("200", "OK");
        expected.put("404", "Not found");

        assertEquals(true, expected.equals(codes));

        codes.put("404", "Not Found");
        System.out.println(codes);

        String s = codes.get("404");
        System.out.println(s);

        codes.put("304", "Not Modified");
        System.out.println(codes);


    }
}