package week11d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairs() {
        assertEquals(1,new PairFinder().findPairs(new int[] {7,6,4,3,8,5,8}));
        assertEquals(1,new PairFinder().findPairs(new int[] {5,1,4,5}));
        assertEquals(5,new PairFinder().findPairs(new int[] {7,0,0,7,0,0,7,0,0,7,0}));
        assertEquals(3,new PairFinder().findPairs(new int[] {7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));
        assertEquals(0,new PairFinder().findPairs(new int[] {}));
        assertEquals(0,new PairFinder().findPairs(new int[] {1,2,3,4,5}));
        assertEquals(1,new PairFinder().findPairs(new int[] {1,2,1,4,5}));

    }
    void findPairsWithMinus() {
        assertEquals(1,new PairFinder().findPairs(new int[] {-7,6,-4,3,8,5,8}));
        assertEquals(1,new PairFinder().findPairs(new int[] {-5,1,4,-5}));
        assertEquals(5,new PairFinder().findPairs(new int[] {7,0,0,7,0,0,7,0,0,7,0}));
        assertEquals(3,new PairFinder().findPairs(new int[] {-7, 1, 5, -7, 3, 3, 9, 7, 6, 7}));
        assertEquals(0,new PairFinder().findPairs(new int[] {}));
        assertEquals(0,new PairFinder().findPairs(new int[] {1,2,3,4,5}));
        assertEquals(1,new PairFinder().findPairs(new int[] {-1,-2,-1,-4,-5}));

    }
}