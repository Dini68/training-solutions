package week03d05;

public class Operation {

    private String leftOperand;

    private String rightOperand;

    public Operation(String addition) {
        this.leftOperand = addition.substring(0, addition.indexOf("+"));
        this.rightOperand = addition.substring(addition.indexOf("+" + 1));
    }

    public int getResult() {
        return Integer.parseInt(leftOperand) + Integer.parseInt(rightOperand);
    }

    public static void main(String[] args) {
        System.out.println(new Operation("78+122").getResult());
    }
}
