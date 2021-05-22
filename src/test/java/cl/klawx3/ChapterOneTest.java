package cl.klawx3;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class ChapterOneTest  {
    private ChapterOne chapterOne;

    @Before
    public void init(){
        chapterOne = new ChapterOne();
    }

    private Map<String,Boolean> generateUniqueCharactersTestSet(){
        Map<String,Boolean> test = new HashMap<>();
        test.put("abc",true);
        test.put("aba", false);
        test.put("cba",true);
        test.put("hello world", false);
        test.put("  ", false);
        test.put("",true);
        return test;
    }

    @Test
    public void testStringHaveUniqueCharacters() {
        generateUniqueCharactersTestSet().forEach( (k,v) -> {
            assertEquals(chapterOne.stringHaveUniqueCharacters(k),v);
        });
    }

    @Test
    public void testStringHavaUniqueCharacterImproved() {
        generateUniqueCharactersTestSet().forEach( (k,v) -> {
            assertEquals(chapterOne.stringHaveUniqueCharactersImproved(k),v);
        });
    }

    @Test
    public void testStringHavaUniqueCharacterNoDataStr() {
        generateUniqueCharactersTestSet().forEach( (k,v) -> {
            assertEquals(chapterOne.stringHaveUniqueCharactersNoDataStructuresOnlyAscii(k),v);
        });
    }

    @Test
    public void testURIlify(){
        char[] input = "Mr John Smith   ".toCharArray();
        int inputLength = 13;
        char[] calculated = chapterOne.URLify(input,inputLength);
        System.out.println(calculated);

        char[] expected = "Mr%20John%20Smith".toCharArray();
        assertArrayEquals(expected,calculated);
    }

    @Test
    public void palindromePermutation(){
        String input = "Tact Coa";
    }

    @Test
    public void oneAwayTest(){
        assertTrue(chapterOne.oneAway("pale", "ple"));
        assertTrue(chapterOne.oneAway("pales", "pale"));
        assertTrue(chapterOne.oneAway("pale", "bale"));
        assertFalse(chapterOne.oneAway("pale", "bake"));
    }

    @Test
    public void stringCompression(){
        assertEquals("a2b1c5a3",chapterOne.stringCompression("aabcccccaaa"));
    }

    @Test
    public void testZeroMatrix(){
        int[][] matrix = new int[][]{{1 ,5 ,6 ,9 ,33,10},
                                     {2 ,4 ,7 ,0 ,3 ,19},
                                     {6 ,3 ,10,15,55,34},
                                     {88,1 ,65,23,54,12},
                                     {0 ,4 , 1, 5, 6, 0}};

        int[][] expected = new int[][]{ {0 ,5 ,6 ,0 ,33,0},
                                        {0 ,0 ,0 ,0 ,0 ,0},
                                        {0 ,3 ,10,0 ,55,0},
                                        {0 ,1 ,65,0 ,54,0},
                                        {0 ,0 ,0 ,0 , 0,0}};

        int[][] result = chapterOne.zeroMatrix(matrix);

        for(int i = 0 ; i < matrix.length ; i++){
            assertArrayEquals(expected[i], result[i]);
        }
        
    }
}