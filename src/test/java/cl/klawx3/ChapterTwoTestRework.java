package cl.klawx3;

import static org.junit.Assert.*;

import org.junit.Test;

import cl.klawx3.datastructure.CrackingCodeInterview.Node;

public class ChapterTwoTestRework {
    
    @Test
    public void isListAPalindrome(){
        Node d = new Node(0);
        d.appendToTail(1);
        d.appendToTail(2);
        d.appendToTail(3);
        
        assertFalse(d.isPalindrome());

        d = new Node(0);
        d.appendToTail(1);
        d.appendToTail(2);
        d.appendToTail(3);
        d.appendToTail(2);
        d.appendToTail(1);
        d.appendToTail(0);
        assertTrue(d.isPalindrome());
        //d.printList();
    }
}
