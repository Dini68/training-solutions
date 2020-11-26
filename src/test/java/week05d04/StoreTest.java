package week05d04;

import org.junit.jupiter.api.Test;
import week05d04.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StoreTest {

    private Store store;
    List<Product> products = Arrays.asList(new Product("tej", 2020, 12, 03),
        new Product("tej", 2020, 12, 03),
        new Product("vaj", 2020, 11, 03),
        new Product("csirkemell", 2020, 11, 23),
        new Product("csokoládé", 2021, 11, 03),
        new Product("tej2", 2020, 11, 27),
        new Product("teavaj", 2020, 11, 25),
        new Product("csirkecomb", 2020, 11, 20),
        new Product("tea", 2021, 10, 03));

    @Test
    public void getNumberOfExpiredTest() {
        assertEquals(4, store.getNumberOfExpired(products));
    }
}
