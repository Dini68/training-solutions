package week07d02.senior;

public interface User {

    static User of(String username, String firstName, String lastName) {
        return new UserImpl(username, firstName, lastName);
    }

    String getUsername();
    String getFirstName();
    String getLastName();
    default String getFullName() {
        return getFirstName() + " " + getLastName();
    };
}
