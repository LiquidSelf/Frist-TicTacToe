package mainapp;

import mylittleplays.MoneyInLong;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class moneyInLongTest {
    MoneyInLong c = new MoneyInLong();
    @Test(expected = Exception.class)

    public void testDiv() throws Exception {
       this.c.div (2,0);

    }
    @Test
    public void testDiv2(){
        assertTrue(c.div(30,15)==2);

    }

}
