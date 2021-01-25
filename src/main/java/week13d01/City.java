package week13d01;

public class City {

    private String postCode;

    private String name;

    private String part;

    public City(String postCode, String name) {
        this.postCode = postCode;
        this.name = name;
    }

    public City(String postCode, String name, String part) {
        this(postCode, name);
        this.part = part;
    }

    public String getPart() {
        return part;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (part == null) {
            return postCode + ": " + name;
        }
        return postCode + ": " + name + ": " + part;
    }
}
//