package cl.klawx3.elementsofprogramminginterview;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class Arrays {

    @Test
    public void testArraysDev(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(8);
        ArraysExe.deleteDuplicatedByBook(list);
    }
    

    @Test
    public void testDeletedDuplicatedElements(){
        assertArrayEquals(new int[]{1,2,3,4,5},
                ArraysExe.deleteDuplicatesFromOrdererArrayV2(new int[]{1,2,2,3,4,5}));
        assertArrayEquals(new int[]{1,2,3,4,5},
                ArraysExe.deleteDuplicatesFromOrdererArrayV2(new int[]{1,1,1,2,2,3,4,5,5,5}));
        assertArrayEquals(new int[]{1,2,3,4,5},
                ArraysExe.deleteDuplicatesFromOrdererArrayV2(new int[]{1,1,1,1,1,2,2,2,3,4,5,5,5}));

        assertArrayEquals(new int[]{1,2,3,4,5},
                ArraysExe.deleteDuplicatesFromOrdererArray(new int[]{1,2,2,3,4,5}));
        assertArrayEquals(new int[]{1,2,3,4,5},
                ArraysExe.deleteDuplicatesFromOrdererArray(new int[]{1,1,1,2,2,3,4,5,5,5}));
        assertArrayEquals(new int[]{1,2,3,4,5},
                ArraysExe.deleteDuplicatesFromOrdererArray(new int[]{1,1,1,1,1,2,2,2,3,4,5,5,5}));

    }
    

    @Test
    public void testMultiply2Arrays(){
        int[] firstInteger = new int[]{1,9,3,7,0,7,7,2,1};
        int[] secondInteger = new int[]{-7,6,1,8,3,8,2,5,7,2,8,7};

        int[] resultInteger = new int[]{-1,4,7,5,7,3,9,5,2,5,8,9,6,7,6,4,1,2,9,2,7};


        assertArrayEquals(resultInteger, ArraysExe.multiply2ArraysOfIntegers(firstInteger,secondInteger));
    }
 
    @Test
    public void testIncrement1InArray(){
        assertArrayEquals(new int[]{1,3,0}, ArraysExe.getIncrementOfArrNumber(new int[]{1,2,9}));
        assertArrayEquals(new int[]{3,0,0}, ArraysExe.getIncrementOfArrNumber(new int[]{2,9,9}));
        assertArrayEquals(new int[]{3,9,2}, ArraysExe.getIncrementOfArrNumber(new int[]{3,9,1}));
    }

    @Test
    public void testArray(){
        int[] n = new int[]{1,2,3,4,5};
        compareArrIfIsEvenThenOdd(ArraysExe.getEvenThenOddV1(n));
    }

    @Test
    public void testArrayV2(){
        int[] n = new int[]{1,2,3,4,5};
        compareArrIfIsEvenThenOdd(ArraysExe.getEvenThenOddV2(n));
    }

    private void compareArrIfIsEvenThenOdd(int[] n){
        boolean comparingEven = true;
        for(int i = 0 ; i < n.length ; i++){
            if(comparingEven && n[i] % 2 != 0) comparingEven = false;            
            if(comparingEven){                
                assertTrue(n[i] % 2 == 0);
            }else{
                assertTrue(n[i] % 2 != 0);
            }
        }
    }

    private void printArr(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
