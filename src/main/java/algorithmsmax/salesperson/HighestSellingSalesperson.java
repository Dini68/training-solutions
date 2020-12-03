package algorithmsmax.salesperson;

import java.util.List;

public class HighestSellingSalesperson {

    public String highestSellingSalesperson (List<Salesperson> salespeople) {
        String salesperson ="";
        int maxAmount = 0;
        for (Salesperson sp: salespeople) {
            if (sp.getAmount() > maxAmount) {
                maxAmount = sp.getAmount();
                salesperson = sp.getName();
            }
        }
        return salesperson;
    }
}
