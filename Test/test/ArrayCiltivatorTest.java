package test;

import org.junit.Test;
import task2.ArrayCiltivator;
import static org.junit.Assert.*;

public class ArrayCiltivatorTest {
    ArrayCiltivator array = new ArrayCiltivator();
    int[] arr = new int[]{5,3,6};
    int[] reversedArray = new int[]{6,3,5};

    @Test
    public void getMinElementTest() throws Exception {
        assertTrue(array.getMinElement(arr) == 3);
    }

    @Test
    public void getSumTest() throws Exception {
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
        sum += arr[i];
        }
        assertFalse(array.getSum(arr) != sum);
    }

    @Test
    public void reverseArrayTest() throws Exception {
        assertArrayEquals(array.reverseArray(arr), reversedArray);
    }

}