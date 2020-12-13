package interfacemethods;

public interface Printable {

    int getLength();

    String getPage(int pageNumber);

    String BLACK = "#000000";

    default String getColor(int pageNumber) {
        return BLACK;
    }
}
