package task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();

    @Test
    public void addProductTest() throws Exception {
        store.addProduct(new Product("Samsung", 50, 5), 2);
        store.addProduct(new Product("Samsung"), 3);
        assertTrue(5 == store.availableOfQuantity("Samsung"));
    }

    @Test
    public void addProductAndSellIt() throws Exception {
        store.addProduct(new Product("Samsung", 50, 5), 3);
        store.sellProduct("Samsung", 3);
        assertTrue(0 == store.availableOfQuantity("Samsung"));
    }

    @Test(expected = NoEnoughSpace.class)
    public void productReachMaxAmount() throws Exception {
        store.addProduct(new Product("Samsung", 50, 5), 4);
        store.addProduct(new Product("Samsung"), 2);

    }

    @Test(expected = NoEnoughProducts.class)
    public void thereIsNoEnoughProductToSell() throws Exception {
        store.addProduct(new Product("Samsung", 50, 5), 4);
        store.sellProduct("Samsung", 5);
    }

    @Test
    public void sortProductsByPrice() throws Exception {
        Product product = new Product("Samsung", 70, 5);
        Product product1 = new Product("Neo", 100, 5);
        Product product2 = new Product("Fujitsu", 50, 5);
        store.addProduct(product, 3);
        store.addProduct(product1, 4);
        store.addProduct(product2, 1);
        Product[] list = new Product[]{product2, product, product1};
        assertArrayEquals(list, store.sortByPrice().toArray());
    }

}