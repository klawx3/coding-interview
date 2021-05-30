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

    /**
     * https://leetcode.com/problems/spiral-matrix/
     */
    @Test
    public void spiralMatixTest(){
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        assertThat(getSpiralMatrix(matrix1))
            .containsExactly(new int[]{1,2,3,6,9,8,7,4,5});

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        assertThat(getSpiralMatrix(matrix2))
            .containsExactly(new int[]{1,2,3,4,8,12,11,10,9,5,6,7});
        
    }

    private int[] getSpiralMatrix(int[][] matrix){
        System.out.print(matrix.length * matrix[0].length);
        boolean horizontal = true;
        boolean forward = true;
        int iOffset = 0, jOffset = 0;
        int vertical_limit = matrix.length, horizontal_limit = matrix[0].length;
        int total_length = matrix.length * matrix[0].length;
        int[] resultList = new int[vertical_limit * horizontal_limit];        
        for(int i = 0, j = 0, m = 0; m < total_length ; m++ ){
            int horizontal_start = jOffset;
            int horizontal_end   = matrix[0].length - jOffset;
            int vertical_start   = iOffset;
            int vertical_end     = matrix.length - iOffset;
            if(j == horizontal_end - 1 && forward && horizontal){
                horizontal = false;
                forward = true;
            }else if(i == vertical_end -1 && forward && !horizontal){
                horizontal = true;
                forward = false;
            }else if(j == horizontal_start && !forward && horizontal){
                iOffset++;
                forward = false;
                horizontal = false;
            }else if(i == vertical_start && !forward && !horizontal){
                jOffset++;
                forward = true;
                horizontal = true;
            }
            resultList[m] = matrix[i][j];            
            if(horizontal && forward){
                j++;
            }else if(horizontal && !forward){
                j--;
            }else if(!horizontal && forward){
                i++;
            }else if(!horizontal && !forward){
                i--;
            }
        } 
        return resultList;
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
