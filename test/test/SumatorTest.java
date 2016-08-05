package test;

import static org.junit.Assert.*;

import org.junit.Test;
import task1.Sumator;


public class SumatorTest {
    Sumator math = new Sumator();

    @Test
    public void SumWithZeroParameters() throws Exception {
        assertTrue(math.sum("0", "0") == 0);
    }

    @Test
    public void SumWithoutZeroParameters() throws Exception {
        assertTrue(math.sum("1", "3") == 4);
    }

    @Test(expected = NumberFormatException.class)
    public void ExpectedNumberFormatException() throws Exception {
        assertTrue(math.sum("c", "5") == 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ExpectedIllegalArgumentException() throws Exception {
        double result = 5;
        assertEquals(math.sum(null, "5"), result, 0);
    }


}



