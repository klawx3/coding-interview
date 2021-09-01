package cl.klawx3;

import org.junit.Test;

import cl.klawx3.datastructure.tree.Tree;

import static org.assertj.core.api.Assertions.*;

public class TreeTest {

    @Test
    public void testTree(){
        Tree tree = new Tree();
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(3);

        // 2 , 1 , 5 ,3 , 6
        tree.preOrder(); // base left right
    }

    @Test
    public void findNumberInTree(){
        Tree tree = new Tree();
        tree.add(2);
        tree.add(1);
        tree.add(5);
        tree.add(6);
        tree.add(3);

        assertThat(tree.existNumber(2)).isTrue();
        assertThat(tree.existNumber(1)).isTrue();
        assertThat(tree.existNumber(5)).isTrue();
        assertThat(tree.existNumber(6)).isTrue();
        assertThat(tree.existNumber(3)).isTrue();

        assertThat(tree.existNumber(4)).isFalse();
        assertThat(tree.existNumber(7)).isFalse();
        assertThat(tree.existNumber(-1)).isFalse();
        assertThat(tree.existNumber(0)).isFalse();
        assertThat(tree.existNumber(20)).isFalse();
    }
    
}
