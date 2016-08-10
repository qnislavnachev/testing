package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();

    @Test
    public void addProduct() throws Exception {
        store.addProduct(new Product("Samsung", 50, 5), 2);
        store.addProduct(new Product("Samsung"), 3);
        assertTrue(5 == store.availableOfQuantity("Samsung"));
    }

    @Test
    public void addSameProductTwiceThenSellIt() throws Exception {
        store.addProduct(new Product("Samsung", 50, 5), 1);
        store.addProduct(new Product("Samsung"), 2);
        store.sellProduct("Samsung", 3);
        assertTrue(0 == store.availableOfQuantity("Samsung"));


    }

    @Test(expected = NoEnoughSpace.class)
    public void addProductReachMaxAmount() throws Exception {
        store.addProduct(new Product("Samsung", 50, 2), 1);
        store.addProduct(new Product("Samsung"), 2);
    }


    @Test(expected = NoEnoughProducts.class)
    public void testSellProductThrowException() throws Exception {
        store.addProduct(new Product("Samsung", 50, 2), 2);
        store.sellProduct("Samsung", 3);
    }

    @Test
    public void testSort() throws Exception {
        Product tv = new Product("Samsung", 50, 10);
        Product tv1 = new Product("Neo", 20, 10);
        Product tv2 = new Product("Fujitsu", 10, 10);
        Product[] arr = new Product[]{tv2, tv1, tv};
        store.addProduct(tv, 4);
        store.addProduct(tv1, 2);
        store.addProduct(tv2, 6);
        assertArrayEquals(arr, store.sort().toArray());

    }


}