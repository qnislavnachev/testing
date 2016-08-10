package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task2.ArrayCiltivator;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ArrayCiltivatorTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void getMinElementTest() throws Exception {
        int[] arr = new int[]{5, 3, 6};
        ArrayCiltivator array = new ArrayCiltivator(arr);
        assertTrue(array.getMinElement() == 3);
    }

    @Test
    public void getSumTest() throws Exception {
        int[] arr = new int[]{5, 3, 6};
        ArrayCiltivator array = new ArrayCiltivator(arr);
        assertTrue(array.getSum() == 14);
    }

    @Test
    public void reverseArrayTest() throws Exception {
        int[] arr = new int[]{5, 3, 6};
        int[] reversedArray = new int[]{6, 3, 5};
        ArrayCiltivator array = new ArrayCiltivator(arr);
        assertArrayEquals(array.reverseArray(), reversedArray);
    }

    @Test
    public void printElementsTest() throws Exception {
        int[] arr = new int[]{5, 3, 6};
        ArrayCiltivator array = new ArrayCiltivator(arr);
        array.printArrayElements();
        assertEquals("[5, 3, 6]", out.toString());

    }

}