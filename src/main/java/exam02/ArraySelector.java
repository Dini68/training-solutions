package exam02;

public class ArraySelector {

    public String selectEvens (int[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Nincs tömb");
        }

        String evenList = "[";
        if (words.length == 0) {
            evenList = "";
        }
        else {
            int index = 0;
            for (int s : words) {
                if (index % 2 == 0) {
                    evenList += s;
                    if (index + 2 < words.length){
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
