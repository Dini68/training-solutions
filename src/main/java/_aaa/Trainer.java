package _aaa;

public class Trainer extends Human{

    private String address;


    public String getAddress() {
        return address;
    }


    public static void main(String[] args) {
//        Trainer t = new Trainer();
//        t.getName();
//        t.getYear();
////        t.getAddress();
//
//        Trainer t2 = (Trainer) new Human();
//        t2.getYear();
//        t2.getName();
////        t2.getAddress();
//
//        Trainer t3 = (Trainer) new Object();
//        t3.getName();
//        t3.getYear();
////        t3.getAddress();

        Human h = new Trainer();
        System.out.println(h.getName());
        System.out.println(h.getClass());
        System.out.println(h.equals(null));
        System.out.println(h.hashCode());

        Human h4 = new Trainer();
        h.getName();
        h.getYear();

    }
}
