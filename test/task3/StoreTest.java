package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();

    @Test
    public void addProductTest() throws Exception {
        store.addProduct(new Product("Neo", 40, 5));
        store.addProduct(new Product("Neo", 40, 3));
        assertTrue(8 == store.availableOfQuantity("Neo"));
    }

    @Test
    public void sellProductTest() throws Exception {
        store.addProduct(new Product("Neo", 30, 10));
        store.sellProduct("Neo", 3);
        assertTrue(7 == store.availableOfQuantity("Neo"));
    }

    @Test(expected = NoEnoughProducts.class)
    public void NoEnoughProductsInStoreToSell() throws Exception {
        store.addProduct(new Product("Neo", 30, 5));
        store.sellProduct("Neo", 7);
    }

    @Test(expected = NoEnoughSpace.class)
    public void filledWarehouse() throws Exception {
        store.addProduct(new Product("Neo", 30, 19));
        store.addProduct(new Product("Neo", 30, 5));
    }

    @Test
    public void sortingByPrice() throws Exception {
        Product p = new Product("Samsung", 50, 10);
        Product p1 = new Product("Neo", 100, 10);
        Product p2 = new Product("Fujitsu", 20, 10);
        store.addProduct(p);
        store.addProduct(p1);
        store.addProduct(p2);
        Product[] sorted = new Product[]{p2, p, p1};
        assertArrayEquals(sorted , store.sortByPrice().toArray());
    }
}