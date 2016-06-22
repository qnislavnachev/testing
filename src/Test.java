/**
 * Created by clouway on 22.06.16.
 */
import org.junit.*;
import org.hamcrest.*;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.internal.builders.JUnit4Builder;

import static org.junit.Assert.*;

public class Test  {
    @org.junit.Test

    public void correctSymbolRecieve(){
        Sumator testone = new Sumator();
        String result = testone.Sum("#","$");
        assertEquals("",result);
    }
    @org.junit.Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        Sumator test = new Sumator();
        String result = test.Sum(null,null);
    }

    @org.junit.Test(expected=NumberFormatException.class)
    public void testNumberFormatException() {
        Sumator test = new Sumator();
        String result = test.Sum(":","$");
    }
}
