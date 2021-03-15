package aaa;

import java.util.*;

public class Training3 implements Set {


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public static void main(String[] args) {
        Training3 tr = new Training3();

        Set<Integer> introSet = new Training3();
        System.out.println(introSet.size());
        List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("qwe1");
        list.add("qwe6");
        list.add("qwe");
        list.add("swe");
        list.add("qwe");
        System.out.println(list);
        System.out.println(list.get(2));

        Set<String> setList = new HashSet<>();
        Set<String> setList2 = new HashSet<>();
        setList.add("klkl");
        setList.add("klkp");
        setList.add("klkl");
        setList.add("k3kl");
        System.out.println(setList.size());
        for (String s: setList) {
            System.out.println(s);
        }
        System.out.println(setList.isEmpty());
        System.out.println(setList.addAll(list));
        System.out.println(setList);
        System.out.println(setList.contains("klkl"));
        System.out.println(setList.contains("k2lkl"));
        System.out.println(setList.containsAll(Arrays.asList("klkl","qwe1")));
        System.out.println(setList.equals(list));

        Queue<String> qu = new ArrayDeque<>();
        qu.add("123");
        qu.add("456");
        qu.add("789");
        System.out.println(qu);
        System.out.println(qu.peek());
        System.out.println(qu);
        System.out.println(qu.poll());
        System.out.println(qu);
        list.add(null);
        System.out.println(list);
        List<Integer> il = new ArrayList<>();
        Integer i = Integer.valueOf(45);
        il.add(i);
        int j = (int)il.get(0);
    }
}
