package exceptions.polinom;

public class Polynomial {


    private double[] coefficients;


    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        double[] convert = new double[coefficientStrs.length];
        try {
            for (int i = 0; i < coefficientStrs.length; i++) {
                convert[i] = Double.parseDouble(coefficientStrs[i]);
            }
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Illegal coefficients, not a number",ex);
        }
        this.coefficients = convert;
    }

    public double evaluate(double x) {
        double sum = 0;
        int length = coefficients.length;
        for (int i = length - 1; i >= 0; i--) {
            sum += coefficients[length - i - 1] * Math.pow(x, i);
        }
        return sum;
    }
    public double[] getCoefficients() {
        return coefficients;
    }

}
