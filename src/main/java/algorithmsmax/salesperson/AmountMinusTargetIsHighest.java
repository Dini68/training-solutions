package algorithmsmax.salesperson;

import java.util.List;

public class AmountMinusTargetIsHighest {

    public String amountMinusTargetIsHighest (List<Salesperson> salespeople) {
        String salesperson = "";
        int maxDifference = 0;
        for (Salesperson sp: salespeople) {
            if (sp.getAmount() - sp.getTarget() > maxDifference) {
                maxDifference = sp.getAmount() - sp.getTarget();
                salesperson = sp.getName();
            }
        }
        return salesperson;
    }
}
