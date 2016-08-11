package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {
    Store store = new Store(20);

    @Test
    public void sellProduct() throws Exception {
        store.addProduct(new Product("Neo", 30, 10));
        store.sellProduct("Neo", 3);
        assertTrue(7 == store.availableOfQuantity("Neo"));
    }
    @Test (expected = WareHouseException.class)
    public void sellingNullProduct() throws Exception {
        store.sellProduct(null, 5);
    }

    @Test(expected = WareHouseException.class)
    public void noEnoughProductsInStoreToSell() throws Exception {
        store.addProduct(new Product("Neo", 30, 5));
        store.sellProduct("Neo", 7);
    }

    @Test(expected = WareHouseException.class)
    public void filledWarehouse() throws Exception {
        store.addProduct(new Product("Neo", 30, 21));

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