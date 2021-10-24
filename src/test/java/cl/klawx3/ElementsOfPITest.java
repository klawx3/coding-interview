package cl.klawx3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import cl.klawx3.elementsofprogramminginterview.*;

public class ElementsOfPITest {

    @Test
    public void testBinarySwap(){
        int value = 4234234;

        Primitives.swapBit(value,0, 3);
    }

    @Test
    public void testfindAClosetIntegerWithTheSameWeight(){
        int f = Primitives.findAClosetIntegerWithTheSameWeight(5);
        System.out.println(f);

    }
    
}
