package mylittleplaystest;

import mylittleplays.MoneyInLong;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoneyInLongTest {

    MoneyInLong c = new MoneyInLong();

    @Test(expected = Exception.class)
    public void testDiv() throws Exception {

       this.c.div (2,0);

    }
    @Test
    public void testDiv2(){

        assertTrue(c.div(30,15)==2);

    }

    @Test(expected = AssertionError.class)
    public void testGetRubasy(){

        assertTrue(c.getRubasy(500, 500, 3)[1] == 4);
    }

    @Test
    public void testGetRubasy2(){

        assertTrue(c.getRubasy(500, 500, 0)[0] == 0);

        assertTrue(c.getRubasy(500, 499, 5)[0] == 0);

        assertTrue(c.getRubasy(500, 499, 5)[0] == 0);
    }


}
