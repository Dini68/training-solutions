package week10d01.senior;

import _toto.ppp.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    public List<String> getList() {
        List<String> result = new ArrayList<>(); // változtatható lista
        result.add("Joe");
        result.add("Jane");

        return result;
    }

    public List<String> getList2() {
        List<String> result = Arrays.asList("Joe", "Jane"); // az értékek változtathatók a mérete nem
        return result;
    }

    public List<String> getList3() {
        List<String> result = List.of("Joe", "Jane"); // semmi sem változtatható;
        return result;
    }

    public List<String> getList4() {
        List<String> result = new ArrayList<>(); // változtatható lista
        result.add("Joe");
        result.add("Smith");

        return List.copyOf(result);
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        List<String> names = demo.getList();
        names.add("Jack");
        System.out.println(names);
        names.clear();
        System.out.println(names);
        List<String> names2 = demo.getList2();
        names2.set(1, "Jack");
        System.out.println(names2);
        List<String> names3 = demo.getList3();
        System.out.println(names3);
        List<String> names4 = demo.getList4();
//        names4.add("Jack");
        System.out.println(names4);
    }
}
