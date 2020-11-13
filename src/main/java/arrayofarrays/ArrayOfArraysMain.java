package arrayofarrays;

public class ArrayOfArraysMain {
    public void printArrayOfArrays(int[][] a) {
        for (int i[] : a) {
            for (int j : i) {
                if (j < 10) {
                    System.out.print("  ");
                } else if (j < 100) {
                    System.out.print(" ");
                }
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[][] multiplicationTable(int size) {
        int [][] multi = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                multi[i-1][j-1] = i * j;
                System.out.print(multi[i-1][j-1] + " ");
            }
            System.out.println();
        }
        return multi;
    }

    public static void main(String[] args) {

        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        System.out.println("Multiplication table");
        arrayOfArraysMain.multiplicationTable(4);
    }


}
