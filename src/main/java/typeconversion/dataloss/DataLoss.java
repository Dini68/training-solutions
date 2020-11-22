package typeconversion.dataloss;

public class DataLoss {

    public void dataLoss(){
        long numberLong = 1L;

        int i = 0;
        while (i<3) {
            numberLong++;
            while ((numberLong == (long) ((float) numberLong)) && (i < 3)) {
                numberLong++;
            }
            System.out.println(numberLong);
            System.out.println(Long.toBinaryString(numberLong));
            System.out.println(Long.toBinaryString((long) ((float) numberLong)));
            i++;
        }
        numberLong = 16777218;
        System.out.println(numberLong);
        System.out.println(Long.toBinaryString(numberLong));
        System.out.println(Long.toBinaryString((long) ((float) numberLong)));
        numberLong = 16777220;
        System.out.println(numberLong);
        System.out.println(Long.toBinaryString(numberLong));
        System.out.println(Long.toBinaryString((long) ((float) numberLong)));

        System.out.println("25 bináris számjegynél");
    }

    public static void main(String[] args) {

        DataLoss dataLoss = new DataLoss();
        dataLoss.dataLoss();
    }
}
