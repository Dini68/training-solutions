package arrayofarrays;

public class ArrayOfArraysMain {

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

    public int[][] triangularMatrix(int size) {
        int[][] tringMatrix = new int[size][size];
        for (int i = 0; i < size; i++ ) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return tringMatrix;
    }

    public static void main(String[] args) {

        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        System.out.println("Multiplication table");
        arrayOfArraysMain.multiplicationTable(4);
        System.out.println();
        arrayOfArraysMain.triangularMatrix(4);
    }


}
