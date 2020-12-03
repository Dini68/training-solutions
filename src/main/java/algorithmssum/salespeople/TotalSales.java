package algorithmssum.salespeople;

import algorithmssum.salespeople.Salesperson;

import java.util.List;

public class TotalSales {

    private List<Salesperson> salespeople;

    public int sumTotalSales (List<Salesperson> salespeople) {
        int sum = 0;
        for (Salesperson sp: salespeople) {
            sum+= sp.getAmount();
        }
        return sum;
    }
}
