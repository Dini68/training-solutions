package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub theBestPub = new Pub("", 23,59);

        for (Pub p: goodPubs) {
            if (p.getOpenFrom().isEarlier(theBestPub.getOpenFrom())) {
                theBestPub = p;
            }
        }
        return theBestPub;
    }
}
