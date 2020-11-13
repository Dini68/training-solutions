package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        boolean contain = false;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
               contain = true;
            }
        }
        return contain;
    }

    public int find(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return source[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();


        int[] source = {1, 2, 3, 4, 5, 6};
        int item = 7;


        System.out.println(arrayHandler.contains(source, item));
        System.out.println(arrayHandler.find(source, item));

    }
}
