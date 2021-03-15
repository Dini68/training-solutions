package _toto.ppp;
public class Builder {
    private String name;
    public Builder setName(String name) {
        this.name = name;
        return this;
    }
    public String build() {
        return name;
    }
    public static void main(String[] args) {
        System.out.print(new Builder().build());
        System.out.print(" ");
        System.out.print(new Builder().setName("John Doe").setName("Jack Doe").build());
    }
}