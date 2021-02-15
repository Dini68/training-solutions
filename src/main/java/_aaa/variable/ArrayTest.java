package _aaa.variable;

import _toto.ppp.A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        // tömb rendezés
        int[] arr = new int[10];
        Arrays.fill(arr, 7); // feltölti a tömböt 7-tel
        System.out.println(Arrays.toString(arr));
        int[] arr3;
        arr3 = arr;
        int[][] arr4 = new int[3][4];
        int[][] arr8;
        Arrays.fill(arr4[0], 10);
        arr8 = arr4;
        Arrays.deepEquals(arr4, arr8); // tömbök tömbjéhez hasonlítás
        Arrays.deepHashCode(arr4); // tömbök tömbjéhez hash
        System.out.println(Arrays.deepToString(arr4)); // tömbök tömbjéhez kiírás
        arr[0] = 5;
        int arr1[], arr41[] = new int[5];
        arr[9] = 5;
        int[] arr2 = {1, 3, 2, 4};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        Integer[] numArr;                       // int nél nem működik a reverse
        numArr = new Integer[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(numArr));
        Arrays.sort(numArr);
        System.out.println(Arrays.toString(numArr));                // számok
        Arrays.sort(numArr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(numArr));
        int[] arr5 = {6, 2, 1, 3, 2, 4, 1};
        Arrays.sort(arr5);
        System.out.println(Arrays.compareUnsigned(arr2, arr5));
        Arrays.compare(arr5, arr3); // összehasonlít 2 tömböt
        System.out.println(Arrays.toString(arr5));
        System.out.println(Arrays.binarySearch(arr5, 2));
        String[] strArr = {"John", "Joe", "Smith", "Abel", "Joe", "Je", "Joe", "Ak"};
        Arrays.sort(strArr);
        int[] arr6 = {6, 2, 1, 3, 2, 4, 1};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr6,2, 5))); // A tömb egy részével tér vissza 2,3,4
        System.out.println(Arrays.compareUnsigned(arr5, arr6));
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.binarySearch(strArr, "Joe"));
        Arrays.sort(strArr);
        Arrays.sort(strArr, Comparator.reverseOrder());
        String test= Arrays.toString(strArr);
        System.out.println(Arrays.toString(Arrays.copyOf(arr6, 3))); // a tömb első 3 elemével tömbként tér vissza
        System.out.println(test.substring(1, test.length()-1));
        List<String> list = Arrays.asList(strArr);
        System.out.println(list);
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr);                                        // stringek
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.equals(arr, arr3));
        Arrays.sort(arr6);
        Arrays.fill(arr5, 2);
        System.out.println(arr5);
        System.out.println(Arrays.hashCode(arr5)); // a tömb hashkódjával tér vissza
        System.out.println(Arrays.equals(arr5, arr6)); // összehasonlít 2 tömböt értékek alapján
        System.out.println(Arrays.toString(arr5));
        System.out.println(Arrays.toString(arr6));
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.binarySearch(strArr, "Smith"));

//        Student[] stdArr = new Student[5];
//
//        stdArr[0] = new Student("Hunor", 600);
//        stdArr[1] = new Student("Viki", 500);
//        stdArr[2] = new Student("Marci", 700);
//        stdArr[3] = new Student("Levi", 300);
//        stdArr[4] = new Student("Füli", 400);
//
//        Student[] copyStdArr = new Student[5];
//        System.arraycopy(stdArr, 0, copyStdArr, 0, stdArr.length);
//        System.out.println("tol");
//        Arrays.sort(copyStdArr, new NameComparator());
//        System.out.println(Arrays.toString(copyStdArr));
//        System.out.println("itt");
//        Arrays.sort(copyStdArr, new BalanceComparator());
//        System.out.println(Arrays.toString(copyStdArr));
//
//        //        Arrays.sort(copyStdArr, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(copyStdArr));
//
//        System.out.println(Arrays.toString(stdArr));
//
//
    }
}
