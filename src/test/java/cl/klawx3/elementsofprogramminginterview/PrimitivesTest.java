package cl.klawx3.elementsofprogramminginterview;

import org.junit.Test;


import static org.junit.Assert.*;

import org.junit.Before;


public class PrimitivesTest {

    private Rectangle b;
    private Rectangle a;
    private Rectangle d;
    private Rectangle c;
    private Rectangle e;

    @Before
    public void setup(){
        a = new Rectangle(new Point(1,1), new Point(3,3));
        b = new Rectangle(new Point(2,2), new Point(3,3));
        d = new Rectangle(new Point(4,0), new Point(6,5));
        c = new Rectangle(new Point(4,1), new Point(9,4));
        e = new Rectangle(new Point(7,2), new Point(9,4));
    }

    @Test
    public void integerPalindrome(){
        
        assertTrue(Primitives.isNumberAPalindrome(1221));
        assertTrue(Primitives.isNumberAPalindrome(123321));
        assertTrue(Primitives.isNumberAPalindrome(1198778911));

        assertFalse(Primitives.isNumberAPalindrome(1234));
        assertFalse(Primitives.isNumberAPalindrome(542352));
        assertFalse(Primitives.isNumberAPalindrome(123412456));

    }

    @Test
    public void getNewRectangleOfIntersection(){
        Rectangle r = Rectangle.getNewRectangleIfIntersect(a, b);
        
        System.out.println(r);

    }

    @Test
    public void rectangleIntersectTest(){
        // testIntersection(a, b,true);
        // testIntersection(c, e,true);
        // testIntersection(c, d,true);
        // testIntersection(a, c,false);
        // testIntersection(a, e,false);
        // testIntersection(e, b,false);
    }

    @Test
    public void testIntersectionV2(){
        testIntersectionV2(a, b,true);
        testIntersectionV2(c, e,true);
        testIntersectionV2(c, d,true);
        testIntersectionV2(a, c,false);
        testIntersectionV2(a, e,false);
        testIntersectionV2(e, b,false);
    }

    private void testIntersection(Rectangle r1,Rectangle r2,boolean assertion){
        if(assertion){
            boolean res1 = Rectangle.isIntersection(r1,r2);
            assertTrue(res1);
            boolean res2 = Rectangle.isIntersection(r2,r1);
            assertTrue(res2);
        }else{
            assertFalse(Rectangle.isIntersection(r1,r2));
            assertFalse(Rectangle.isIntersection(r2,r1));
        }
    }

    private void testIntersectionV2(Rectangle r1,Rectangle r2,boolean assertion){
        if(assertion){
            boolean res1 = Rectangle.isIntersectionV2(r1,r2);
            assertTrue(res1);
            boolean res2 = Rectangle.isIntersectionV2(r2,r1);
            assertTrue(res2);
        }else{
            assertFalse(Rectangle.isIntersectionV2(r1,r2));
            assertFalse(Rectangle.isIntersectionV2(r2,r1));
        }
    }

    @Test
    public void rectagleContainedTest(){
        assertTrue(Rectangle.isContained(a, b));
        assertFalse(Rectangle.isContained(a, c));
        assertTrue(Rectangle.isContained(b, a));
        assertTrue(Rectangle.isContained(c, e));
        assertFalse(Rectangle.isContained(c, d));
        assertFalse(Rectangle.isContained(b, c));
    }

    @Test
    public void testRectangleArea(){
        Rectangle a = new Rectangle(new Point(1,1), new Point(3,3));
        Rectangle b = new Rectangle(new Point(2,2), new Point(3,3));
        Rectangle d = new Rectangle(new Point(4,0), new Point(6,5));
        Rectangle c = new Rectangle(new Point(4,1), new Point(9,4));
        Rectangle e = new Rectangle(new Point(7,2), new Point(9,4));

        assertEquals(a.getArea(),4);
        assertEquals(b.getArea(),1);
        assertEquals(d.getArea(),10);
        assertEquals(c.getArea(),15);
        assertEquals(e.getArea(),4);
    }
    
}
