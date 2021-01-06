package exam02;

public class ArraySelector {

    public String selectEvens (int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Nincs tömb");
        }

        String evenList = "[";
        if (numbers.length == 0) {
            evenList = "";
        }
        else {
            int index = 0;
            for (int s : numbers) {
                if (index % 2 == 0) {
                    evenList += s;
                    if (index + 2 < numbers.length){
                        evenList += ", ";
                    }
                }
                else { }
                index++;
            }

        evenList += "]";
    }
        System.out.println(evenList);
        return evenList;
}

}
