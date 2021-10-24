package cl.klawx3.self;

import java.util.Arrays;

import org.junit.Test;

import cl.klawx3.other.ArrayOrder;

public class ListSearch {
    
    @Test
    public void testo(){
        int valueToSearch = 100;
        
        int a[] = new int[]{4,5,1,-5,-1,5,100,45,23,2,9,4,23,5,0,1,55};
        ArrayOrder.orderArray(a);
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));
        System.out.println();
        int index = ArraySearch.binarySearch(a,valueToSearch);
        
        if(index != -1)
            System.out.printf("index: %d , indexValue: %d", index, a[index]);
        else
            System.out.printf("number %d does't exist" , valueToSearch);
    }
}
