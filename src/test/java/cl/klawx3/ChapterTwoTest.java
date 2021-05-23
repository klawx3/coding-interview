package cl.klawx3;

import org.junit.Before;
import org.junit.Test;

import cl.klawx3.datastructure.list.SingleLinkedList;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;

public class ChapterTwoTest {

    private ChapterTwo chapterTwo;
    @Before
    public void init(){
        chapterTwo = new ChapterTwo();
    }

    @Test
    public void uniqueElementsSingleListTest(){
        SingleLinkedList lk = new SingleLinkedList();
        lk.appendToFront(1); 
        lk.appendToFront(2); 
        lk.appendToFront(2);
        lk.appendToFront(2);  
        lk.deleteDuplicatesElements();
        assertThat((Iterable)lk)
            .containsExactly(1,2);

    }

    @Test
    public void uniqueElementsSingleListTestWithoutBuffer(){
        SingleLinkedList lk = new SingleLinkedList();
        lk.appendToFront(1);
        lk.appendToFront(2);
        lk.appendToFront(5);
        lk.appendToFront(2);
        lk.appendToFront(4);
        lk.appendToFront(2);  
        lk.appendToFront(2); 
        lk.appendToFront(2);       
        lk.deleteDuplicateElementsNoBuffer();
        lk.printList();
        assertThat((Iterable)lk)
            .containsExactly(1,2,5,4);
    }

    @Test
    public void getTheNLastElementTest(){
        SingleLinkedList lk = new SingleLinkedList();
        lk.appendToFront(1);// 0
        lk.appendToFront(2);// 1
        lk.appendToFront(5);// 2
        lk.appendToFront(2);// 3
        lk.appendToFront(4);// 4

        assertThat((Iterable)lk)
            .element(4).isEqualTo(lk.get_Nth_LastElement(1));

        assertThat((Iterable)lk)
            .element(3).isEqualTo(lk.get_Nth_LastElement(2));

        assertThat((Iterable)lk)
            .element(2).isEqualTo(lk.get_Nth_LastElement(3));
    }
    
}
