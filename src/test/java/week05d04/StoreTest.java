package week05d04;

import org.junit.jupiter.api.Test;
import week05d04.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StoreTest {

    @Test
    public void addProductTest() {
        Store store = new Store();

        assertTrue(store.addProduct(new Product("tej", 2020, 12, 03)));
        assertFalse(store.addProduct(new Product("vaj", 2020, 11, 03)));
        assertTrue(store.addProduct(new Product("csirkemell", 2020, 11, 28)));
        assertTrue(store.addProduct(new Product("csokoládé", 2021, 11, 03)));
        assertFalse(store.addProduct(new Product("tej", 2020, 11, 27)));
        assertFalse(store.addProduct(new Product("teavaj", 2020, 11, 25)));
        assertFalse(store.addProduct(new Product("csirkemell", 2020, 11, 30)));
        assertTrue(store.addProduct(new Product("tea", 2021, 10, 03)));

    }
    @Test
    public void getNumberOfExpiredTest() {
        List<Product> testList = new ArrayList<>();
        testList.add(new Product("csirkemell", 2020, 11, 30));
        testList.add(new Product("csirkemell", 2020, 11, 30));
        testList.add(new Product("tea", 2021, 10, 03));
        Store store = new Store();

        assertEquals(3,store.getNumberOfNonExpired(testList));
    }
}
