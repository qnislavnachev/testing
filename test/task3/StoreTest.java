package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();

    @Test
    public void addProductTest() throws Exception {
        Product p1 = new Product("Samsung", 50, 10);
        Product p2 = new Product("Neo", 30, 10);
        store.addProduct(p1, 5);
        store.addProduct(p1, 3);
        store.addProduct(p2, 3);
        assertTrue(8 == store.availableOfQuantity(p1));
        assertTrue(3 == store.availableOfQuantity(p2));
    }

    @Test
    public void sellProductTest() throws Exception {
        Product p = new Product("Samsung", 50, 10);
        store.addProduct(p, 4);
        store.sellProduct(p, 2);
        assertTrue(2 == store.availableOfQuantity(p));
    }

    @Test(expected = NoEnoughProducts.class)
    public void NoEnoughProductsInStoreToSell() throws Exception {
        Product p = new Product("Neo", 50, 10);
        store.addProduct(p, 4);
        store.sellProduct(p, 5);
    }

    @Test(expected = NoEnoughSpace.class)
    public void filledWarehouse() throws Exception {
        Product p = new Product("Neo", 50, 10);
        store.addProduct(p, 6);
        store.addProduct(p, 7);
    }

    @Test
    public void sortingByPrice() throws Exception {
        Product p = new Product("Samsung", 50, 10);
        Product p1 = new Product("Neo", 100, 10);
        Product p2 = new Product("Fujitsu", 20, 10);
        store.addProduct(p, 1);
        store.addProduct(p1, 1);
        store.addProduct(p2, 1);
        Product[] sorted = new Product[]{p2, p, p1};
        assertArrayEquals(sorted, store.sortByPrice().toArray());
    }
}