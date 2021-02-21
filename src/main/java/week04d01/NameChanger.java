package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalStateException("Invalid name:" + fullName);
        }
        this.fullName = fullName;
    }

    public void changeFirstName (String firstName) {
        this.fullName = firstName + " " + fullName.split(" ")[1];
    }

    public String getFullName() {
        return fullName;
    }

    public static void main(String[] args) {
        NameChanger nameChanger = new NameChanger("Kovács Hunor");
        System.out.println(nameChanger.getFullName());
        nameChanger.changeFirstName("Simon");
        System.out.println(nameChanger.getFullName());
    }
}
