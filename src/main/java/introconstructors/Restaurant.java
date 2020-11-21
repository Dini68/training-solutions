package introconstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {

        this.name = name;
        this.capacity = numberOfTables * 4;
        aktMenu();
  }

    public void aktMenu() {
        this.menu.add("leves");
        this.menu.add("kacsahús");
        this.menu.add("somlói");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
