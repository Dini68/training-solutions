package week06d01.senior;

public class SeparatedSum {

    public int sum (String numbersString) {
        int sum = 0;
        String[] numbers = numbersString.split(";");
        for (String s: numbers) {
            sum+= Integer.parseInt(s.split(",")[0]) +
                  Integer.parseInt(s.split(",")[1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SeparatedSum().sum("-158,564;-453,678"));
    }
}
