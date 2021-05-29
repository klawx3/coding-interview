package cl.klawx3;
import static org.assertj.core.api.Assertions.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.junit.Test;


public class LeetCode {
    /** 
     * https://leetcode.com/problems/simplify-path/
     */
    @Test
    public void simplifyPath(){
        assertThat(simplifyPathAlgorithm("/home/"))
            .isEqualTo("/home");

        assertThat(simplifyPathAlgorithm("/home//foo/"))
            .isEqualTo("/home/foo");

        assertThat(simplifyPathAlgorithm("/a/./b/../../c/"))
            .isEqualTo("/c");
    }

    private String simplifyPathAlgorithm(String path){
        Deque<String> deque = new LinkedList<>();
        for(String rute: path.split("/")){
            if(rute.contentEquals("..")){
                try{
                    deque.pop();
                }catch(NoSuchElementException e){}                
            }else if(!rute.contentEquals(".") && !rute.isEmpty()){
                deque.push(rute);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while(!deque.isEmpty()){
            sb.append(deque.removeLast());
            if(!deque.isEmpty())
                sb.append("/");
        }
        return sb.toString();
    }
}
