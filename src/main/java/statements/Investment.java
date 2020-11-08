package statements;

public class Investment {

    private double cost;

    private int fund;

    private int interestRate;

    private boolean active;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        this.active = true;
    }

    public int getFund() {

        return fund;
    }

    public double getYield(int days) {
        return fund * days / 365.0 * interestRate / 100.0;
    }

    public double close(int days) {
        int live = 1;
        live = active ? 1 : 0;
        active = false;
        return live * 0.997 * (getYield(days) + fund);
    }
}

