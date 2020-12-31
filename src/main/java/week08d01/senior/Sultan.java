package week08d01.senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sultan {


    public boolean[] openDoors(int doorNumber) {
        boolean[] openDoors = new boolean[doorNumber];
        int j = 0;
        boolean open = false;
        while (j < doorNumber) {
            j++;
            int index = 0;
            while (index < doorNumber) {
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
        int i = 0;
        for (Boolean b: sultan.openDoors(200)) {
            i++;
            System.out.print(i + ": ");
            if (b) System.out.println("<<--- " + b);
            if (!b) System.out.println(b);
        }
    }
}
