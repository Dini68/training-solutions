package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub theBestPub = new Pub("", 24,0);

        for (Pub p: goodPubs) {
            if (p.getOpenFrom().isEarlier(theBestPub.getOpenFrom())) {
                theBestPub = p;
            }
        }
        return theBestPub;
    }
}
