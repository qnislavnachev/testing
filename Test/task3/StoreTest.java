package task3;

import org.junit.Test;
import static org.junit.Assert.*;

public class StoreTest {

    private Store store = new Store();
    private Products tv = new Products("Samsung", 50 , 5);
    private Products fridge = new Products("Neo", 70 , 4);
    private Products dishWasher = new Products("Neo", 10, 10);

    @Test
    public void testAddProduct() throws Exception {
        store.addProduct(tv,2);
        assertTrue(2 == store.getAmount(tv));
    }

    @Test
    public void testAddProductMoreThenOneTimes() throws Exception {
        store.addProduct(tv,2);
        store.addProduct(tv,4);
        assertTrue(6 == store.getAmount(tv));
    }

    @Test(expected = NoEnoughSpace.class)
    public void testAddProductMaxAmount() throws Exception {
        store.addProduct(tv,6);
    }


    @Test
    public void testSellProduct() throws Exception {
        store.addProduct(tv,5);
        store.sellProduct(tv,3);
        assertTrue(2 == store.getAmount(tv));
    }

    @Test(expected = NoEnoughProducts.class)
    public void testSellProductThrowException() throws Exception {
        store.addProduct(tv,5);
        store.sellProduct(tv,3);
        store.sellProduct(tv,3);
    }

    @Test
    public void testSort() throws Exception {
        Products[] arr = new Products[]{dishWasher,tv,fridge};
        store.addProduct(tv,4);
        store.addProduct(fridge,2);
        store.addProduct(dishWasher,6);
        assertArrayEquals(arr, store.sort().toArray());

    }


}