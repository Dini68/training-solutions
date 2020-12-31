package week08d01.senior;

import java.util.ArrayList;
import java.util.List;

public class Sultan {


    public boolean[] openDoors() {
        boolean[] openDoors = new boolean[100];
        int j = 0;
        boolean open = false;
        while (j < 100) {
            j++;
            int index = 0;
            while (index < 100) {
                for (Boolean b: openDoors) {
                    index ++;
                    if (index % j == 0) {
                        open = openDoors[index - 1];
                        openDoors[index - 1] = !open;
                    }
                }
            }
        }
        return openDoors;


    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan();
        System.out.println(sultan.openDoors());
        int i = 0;
        for (Boolean b: sultan.openDoors()) {
            i++;
            System.out.print(i + ": ");
            System.out.println(b);
        }
    }
}
