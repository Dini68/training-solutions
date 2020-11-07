package week2;

import java.util.Scanner;

public class Phone {

    private String type;

    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Phone type: ");
        String type1 = scanner.nextLine();
        System.out.print("1. Phone mem: ");
        int mem1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("2. Phone type: ");
        String type2 = scanner.nextLine();
        System.out.print("2. Phone mem: ");
        int mem2 = scanner.nextInt();
        scanner.nextLine();

        Phone phone1 = new Phone(type1, mem1);

        Phone phone2 = new Phone(type2, mem2);

        System.out.println(phone1.getType()+" "+phone1.getMem());

        System.out.println(phone2.getType()+" "+phone2.getMem());
    }
}
