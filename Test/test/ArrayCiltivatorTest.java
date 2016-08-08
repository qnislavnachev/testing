package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task2.ArrayCiltivator;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ArrayCiltivatorTest {
    ArrayCiltivator array = new ArrayCiltivator();
    int[] arr = new int[]{5,3,6};
    int[] reversedArray = new int[]{6,3,5};
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
        assertTrue(array.getMinElement(arr) == 3);
    }

    @Test
    public void getSumTest() throws Exception {
        assertTrue(array.getSum(arr) == 14);
    }

    @Test
    public void reverseArrayTest() throws Exception {
        assertArrayEquals(array.reverseArray(arr), reversedArray);
    }

    @Test
    public void printElementsTest() throws Exception {
        array.printArrayElements(arr);
        assertEquals("[5, 3, 6]", out.toString());

    }

}