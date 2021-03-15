package _aaa.variable;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.*;

public class Convert {

    public static void main(String[] args) {

        byte b = 90;
        short s = 90;
        int i = 90;
        long l = 90;
        double d = 90;
        System.out.println(d);
        float f = 90;
        System.out.println(f);
        char ch = 90;
        System.out.println(ch);
        boolean bo = false;

        byte bmax = Byte.MAX_VALUE;
        System.out.println(bmax);
        byte bmin = Byte.MIN_VALUE;
        System.out.println(bmin);
        System.out.println(b);
        b = (byte) 1000;
        System.out.println(b);
        b = (byte) s;
        System.out.println(b);
        b = (byte) i;
        System.out.println(b);
        b = (byte) l;
        System.out.println(b);
        b = (byte) d;
        System.out.println(b);
        b = (byte) f;
        System.out.println(b);
        b = (byte) ch;
        System.out.println(b);

        short smax = Short.MAX_VALUE;
        System.out.println(smax);
        short smin = Short.MIN_VALUE;
        System.out.println(smin);
        System.out.println(s);
        s = (short) 100000;
        System.out.println(s);
        s = b;
        System.out.println(s);
        s = (short) i;
        System.out.println(s);
        s = (short) l;
        System.out.println(s);
        s = (short) d;
        System.out.println(s);
        s = (short) f;
        System.out.println(s);
        s = (short) ch;
        System.out.println(s);

        int imax = Integer.MAX_VALUE;
        System.out.println(imax);
        int imin = Short.MIN_VALUE;
        System.out.println(imin);
        System.out.println(i);
        i = (int) 10_000_000_000L;
        System.out.println(i);
        i = b;
        System.out.println(i);
        i = s;
        System.out.println(i);
        i = (int) l;
        System.out.println(i);
        i = (int) d;
        System.out.println(i);
        i = (int) f;
        System.out.println(i);
        i = ch;
        System.out.println(i);

        long lmax = Long.MAX_VALUE;
        System.out.println(lmax);
        long lmin = Long.MIN_VALUE;
        System.out.println(lmin);
        System.out.println(l);
        l = 1_000_000_000_000_000_000L;
        System.out.println(l);
        l = b;
        System.out.println(l);
        l = s;
        System.out.println(l);
        l = i;
        System.out.println(l);
        l = (long) d;
        System.out.println(l);
        l = (long) f;
        System.out.println(l);
        l = ch;
        System.out.println(l);

        double dmax = Double.MAX_VALUE;
        System.out.println(dmax);
        double dmin = Double.MIN_VALUE;
        System.out.println(dmin);
        System.out.println(d);
        d = 1_000_000_000_000_000_00000000000000000000000000000000000000000000000000000.0;
        System.out.println(d);
        System.out.println(Math.round(d));
        d = b;
        System.out.println(d);
        d = s;
        System.out.println(d);
        d = i;
        System.out.println(d);
        d = l;
        System.out.println(d);
        d = f;
        System.out.println(d);
        d = ch;
        System.out.println(d);

        float fmax = Float.MAX_VALUE;
        System.out.println(fmax);
        float fmin = Float.MIN_VALUE;
        System.out.println(fmin);
        System.out.println(f);
        f = 1_000_000_000_000_000_00000000000000000000000.0F;
        System.out.println(f);
        System.out.println(Math.round(f));
        f = b;
        System.out.println(f);
        f = s;
        System.out.println(f);
        f = i;
        System.out.println(f);
        f = l;
        System.out.println(f);
        f = (float) d;
        System.out.println(f);
        f = ch;
        System.out.println(f);

        ch = Character.MIN_VALUE;
        System.out.println(ch);
        ch = Character.MAX_VALUE;
        System.out.println(ch);
        ch = (char) b;

        ch = (char) s;

        List<String> li = new List<String>() {
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
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public String set(int index, String element) {
                return null;
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        System.out.println(li.size());

        Set<String> se = new Set<String>() {
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
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        Queue<String> qu = new Queue<String>() {
            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean offer(String s) {
                return false;
            }

            @Override
            public String remove() {
                return null;
            }

            @Override
            public String poll() {
                return null;
            }

            @Override
            public String element() {
                return null;
            }

            @Override
            public String peek() {
                return null;
            }

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
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        Map<String, String> ma = new Map<String, String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(String key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<String> values() {
                return null;
            }

            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        };

        Collection<String> co = new Collection<String>() {
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
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        List<String> liArr;
        liArr = new ArrayList<>(Arrays.asList("hely", "állat", "Éva", "hely", "János", "Jól", "jól"));
        System.out.println(liArr);
        liArr.add("Tünde");
        liArr.add("Dénes");
        liArr.add("Hunor");
        Collections.sort(liArr, Collator.getInstance(new Locale("hu", "HU")));
        Collections.sort(liArr, Comparator.reverseOrder());
        System.out.println(liArr);

        List<String> liLink = new LinkedList<>();
        liLink = Arrays.asList("hely", "állat", "hely", "Éva", "János", "Jól", "jól");
        Collections.sort(liLink, Collator.getInstance(new Locale("hu", "HU")));
        System.out.println(liLink);

        System.out.println(liArr.get(8));
        System.out.println((liArr.set(6, "Jól")));
        System.out.println(liArr);
        liArr.add(3, "kakukk");
        System.out.println(liArr);
        System.out.println(liArr.remove(1));
        System.out.println(liArr);
        System.out.println(liArr.indexOf("Tünde"));
        System.out.println(liArr.lastIndexOf("Jól"));
        System.out.println(liArr.subList(3, 7));

        Collections.sort(liArr,Collator.getInstance(new Locale("hu", "HU")).reversed());
        System.out.println(liArr);

        Set<String> setHash = new HashSet<String>();
        Set<String> setLinked = new LinkedHashSet<>();
        Set<String> setTree = new TreeSet<>();

        setHash.addAll(liArr);
        System.out.println(setHash);
        liArr.clear();
        liArr.addAll(setHash);
        Collections.sort(liArr,Collator.getInstance(new Locale("hu", "HU")));
        System.out.println(liArr);


    }
}
