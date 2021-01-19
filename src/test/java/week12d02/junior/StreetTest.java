package week12d02.junior;

import org.junit.jupiter.api.Test;
import week12d02.junior.Fence;
import week12d02.junior.Site;
import week12d02.junior.Street;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    public void getFenceStatsTest () {

        Street street = new Street();

        street.sellSite(new Site(0, 10, Fence.PERFECT));
        street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        street.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        street.sellSite(new Site(0, 9, Fence.PERFECT));
        street.sellSite(new Site(0, 11, Fence.NO_FENCE));
        street.sellSite(new Site(1, 13, Fence.PERFECT));

        assertEquals(3, street.getLastSiteNumber());


        System.out.println(street.getFenceStats());
        System.out.println(street.sites.toString());

    }

}


/*
   0 10 PERFECT
           0 7 NEED_UPGRADE
           1 12 NEED_UPGRADE
           0 9 PERFECT
           0 11 NO_FENCE
           1 13 PERFECT*/