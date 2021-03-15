package aaa;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntroMap {

    private Map<String, List<Integer>> subjects = new TreeMap<>();

    public static void main(String[] args) {
        IntroMap iM = new IntroMap();
        iM.subjects.put("Dénes", Arrays.asList(5,4,3,5,3,4));
        iM.subjects.put("Tünde", Arrays.asList(3,2,5,2,3,4));
        iM.subjects.put("Hunor", Arrays.asList(5,4,5,5,4,4));
        System.out.println(iM.subjects);
        if (iM.subjects.containsKey("Dénes")) {
            System.out.println(iM.subjects.get("Dénes"));
        }
        System.out.println(iM.subjects);
    }
}
