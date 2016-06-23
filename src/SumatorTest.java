/**
 * Created by clouway on 22.06.16.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class SumatorTest {
    @Test
    public void correctSymbolRecieve() {
        Sumator testone = new Sumator();
        String result = testone.sum("3", "5");
        assertEquals("8", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothArgumentsAreNull() {
        Sumator sumator = new Sumator();
        sumator.sum(null, null);
    }

    @Test(expected = NumberFormatException.class)
    public void testNumberFormatException() {
        Sumator test = new Sumator();
        String result = test.sum(":", "$");
    }
}
