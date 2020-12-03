package formatlocalprintf;

public class PrintFormat {

    public String checkException(String formatString, Integer i, Integer j) {

        return "";
    }
    public String printFormattedText(Double number) {
        return String.format("%8.2f",number);
    }
    public String printFormattedText(int count, String fruit) {
        return String.format("%d %s",count,fruit);
    }
    public String printFormattedText(int number) {
        return String.format("%d",number);
    }
    public String printFormattedText(Integer i, Integer j, Integer k){
        return String.format("");
    }
}
