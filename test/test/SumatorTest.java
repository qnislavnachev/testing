package test;

import static org.junit.Assert.*;

import org.junit.Test;
import task1.Sumator;


public class SumatorTest {
    Sumator math = new Sumator();

    @Test
    public void sumWithZeroParameters() throws Exception {
        assertTrue(math.sum("0", "0") == 0);
    }

    @Test
    public void sumWithoutZeroParameters() throws Exception {
        assertTrue(math.sum("1", "3") == 4);
    }

    @Test(expected = NumberFormatException.class)
    public void sumWithOneOfArgumentsIsChar() throws Exception {
        assertTrue(math.sum("c", "5") == 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumWithFirstArgumentEqualsNull() throws Exception {
        double result = 5;
        assertEquals(math.sum(null, "5"), result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumWithSecondArgumentEqualsNull() throws Exception {
        double result = 5;
        assertTrue(result == math.sum("5", null));
    }


}



