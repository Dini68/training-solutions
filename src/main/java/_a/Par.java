package _a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Par {

    private Map<String, String> words = new HashMap<>();

    public Map<String, String> getWords() {
        return words;
    }

    public void addWords (String key, String value) {
        words.put(key, value);
    }
    private List<String> names = new ArrayList<>();
    public List<String> getNames() {
        return new ArrayList<>(names);
    }
    public void addNames (String name) {
        names.add(name);
    }
    public void findNames (String name) {
        for (String s: names) {
            if (s.equals(name)) {
                return;
            }
        }
    }

}
