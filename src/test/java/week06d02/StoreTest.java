package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StoreTest {

    @Test
    public void getProductByCategoryNameTest() {
        Store store = new Store(Arrays.asList(
        new Product("alma", Category.OTHER, 500),
        new Product("banán", Category.OTHER, 400),
        new Product("tej", Category.DAIRY, 200),
        new Product("vaj", Category.DAIRY, 350),
        new Product("kifli", Category.BAKEDGOODS, 40),
        new Product("tej", Category.FROZEN, 200),
        new Product("vaj", Category.FROZEN, 350),
        new Product("kifli", Category.FROZEN, 40)
        ));

        assertEquals(3, store.getProductByCategoryName(Category.FROZEN));
        assertEquals(2, store.getProductByCategoryName(Category.DAIRY));
    }
}
