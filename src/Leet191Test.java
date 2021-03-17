import org.junit.Test;

import static org.junit.Assert.*;

public class Leet191Test {

    @Test(timeout = 100)
    public void testHammingWeight(){
        Leet191 leet = new Leet191();
        assertEquals(leet.hammingWeight(0),0);
        assertEquals(leet.hammingWeight(1),1);
        assertEquals(leet.hammingWeight(7),3);
        assertEquals(leet.hammingWeight(-3),31);
        assertEquals(leet.hammingWeight(-1),32);

        assertEquals(leet.hammingWeight1(0),0);
        assertEquals(leet.hammingWeight1(1),1);
        assertEquals(leet.hammingWeight1(7),3);
        assertEquals(leet.hammingWeight1(-3),31);
        assertEquals(leet.hammingWeight1(-1),32);
    }

}