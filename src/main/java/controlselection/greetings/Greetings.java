package controlselection.greetings;

public class Greetings {

    public String Greet( int hour, int minute){

        String s = "";

        if  ((hour * 60 + minute <= 300) || (hour * 60 + minute > 1200)) {
            s = "Jó éjt!";
        }

        if  ((hour * 60 + minute > 300) && (hour * 60 + minute <= 540)) {
            s = "Jó reggelt!";
        }

        if  ((hour * 60 + minute > 540) && (hour * 60 + minute <= 1110)) {
            s = "Jó napot!";
        }

        if  ((hour * 60 + minute > 1110) && (hour * 60 + minute <= 1200)) {
            s = "Jó estét!";
        }

        return s;

    }

    public static void main(String[] args) {

        Greetings greetings = new Greetings();
        System.out.println(greetings.Greet(20,30));
    }
}
