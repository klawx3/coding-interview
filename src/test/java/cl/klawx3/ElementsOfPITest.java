package cl.klawx3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ElementsOfPITest {

    @Test
    public void testBinarySwap(){
        int value = 4234234;

        ElementsOfProgramingInterview.swapBit(value,0, 3);
    }

    @Test
    public void testfindAClosetIntegerWithTheSameWeight(){
        int f = ElementsOfProgramingInterview.findAClosetIntegerWithTheSameWeight(5);
        System.out.println(f);

    }
    
}
