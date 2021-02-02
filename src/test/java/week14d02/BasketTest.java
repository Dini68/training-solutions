package week14d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    void readFileToMap() {
        Basket basket = new Basket();
        basket.readFileToMap("shopping_list.txt");
        assertEquals(Arrays.asList("apple","beer", "pear", "sugar"), basket.listBasket("A312"));
        assertEquals(2, basket.countProduct("beer"));
        assertEquals(8, basket.numberOfProductById("W34111"));
        assertEquals(3, basket.stat().get("sugar"));
        assertEquals(27, basket.stat().size());
    }
}