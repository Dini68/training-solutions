package aaa;

import java.util.*;

public class introCollection {

    public static void main(String[] args) {

        Collection cl = new ArrayList();
        System.out.println("cl.size(): " + cl.size());
        System.out.println("cl.isEmpty(): " + cl.isEmpty());
        System.out.println("cl.add(\"world\"): " + cl.add("world"));
        System.out.println("cl.add(12): " + cl.add(12));
        System.out.println("cl.add(null): " + cl.add(null));
        System.out.println("cl.add(false): " + cl.add(false));
        System.out.println("      Collections elements:   " + cl);
        System.out.println("cl.remove(12): " + cl.remove(12));
        System.out.println("      Collections elements:   " + cl);
        System.out.println("cl.clear(): ");
        cl.clear();
        System.out.println("      Collections elements:   " + cl);
        System.out.println("cl.contains(15): " + cl.contains(15));


        List l = new ArrayList(Arrays.asList("kl", 12, true));
        l.add(1, "fdf");
        System.out.println(l);
        System.out.println(l.get(2));
        System.out.println(l.indexOf("10"));
        System.out.println(l.lastIndexOf("fdf"));
        System.out.println(l.remove(0 ));
        System.out.println(l.set(2, "ilo"));
        System.out.println(l);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        System.out.println(q);
        System.out.println(q.element());
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        Deque<Integer> d = new LinkedList<>();
        d.push(1);
        d.push(2);
        d.push(3);

        System.out.println(d.peek());
        System.out.println(d);
        System.out.println(d.pop());
        System.out.println(d);
        System.out.println(d.pop());
        System.out.println(d);
        System.out.println(d.pop());
        System.out.println(d);
        System.out.println(d.isEmpty());


    }
}
