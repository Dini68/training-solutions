package controlselection.greetings;

public class Greetings {

    public String greet( int hour, int minute){

        String s = "";

        if  ((hour * 60 + minute <= 300) || (hour * 60 + minute > 1200)) {
            s = "jó éjt";
        }

        if  ((hour * 60 + minute > 300) && (hour * 60 + minute <= 540)) {
            s = "jó reggelt";
        }

        if  ((hour * 60 + minute > 540) && (hour * 60 + minute <= 1110)) {
            s = "jó napot";
        }

        if  ((hour * 60 + minute > 1110) && (hour * 60 + minute <= 1200)) {
            s = "jó estét";
        }

        return s;

    }

    public static void main(String[] args) {

        Greetings greetings = new Greetings();
        System.out.println(greetings.greet(20,30));
    }
}
