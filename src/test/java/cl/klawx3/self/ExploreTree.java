package cl.klawx3.self;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.sound.sampled.SourceDataLine;

import org.junit.Test;

import cl.klawx3.datastructure.tree.Tree;

public class ExploreTree {

    class TNode {
        int value;
        TNode left;
        TNode right;

        public TNode(int value){this.value = value;}
    }

    class BSTIterator {
        public BSTIterator(TNode root) {
        }
    
        public int next() {
            return 0;
        }
    
        public boolean hasnext() {
            return true;
        }
    }

    private TNode generateTree(){
        TNode root = new TNode(4);
        TNode l1 = new TNode(2);
        TNode r1 = new TNode(7);
        TNode r2 = new TNode(5);
        TNode r3 = new TNode(9);

        root.left = l1;
        root.right = r1;
        r1.left = r2;
        r1.right = r3;

        //      4
        //     / \
        //    2   7
        //       / \
        //      5   9
        return root;
    }



    @Test
    public void recursiveTree(){
        TNode root = generateTree();

        List<Integer> list = new ArrayList<>();
        recurseTree(root,list);

        List<Integer> list2 = new ArrayList<>();
        recurseTreeWithStack(root,list2);
        list2.forEach(e -> System.out.print(e + " "));
        assertEquals(list, list2);  

        
    }



    private void recurseTree(TNode root,List<Integer> list) {
        if (root == null) return;
        recurseTree(root.left,list);
        list.add(root.value);
        recurseTree(root.right,list);
    }

    private void recurseTreeWithStack(TNode root,List<Integer> list){
        Stack<TNode> stack = new Stack<>();
        fillStack(root,stack);
        while(!stack.empty()){
            TNode pop = stack.pop();
            fillStack(pop.right,stack);
            list.add(pop.value);
        }
    }

    private void fillStack(TNode node,Stack<TNode> stack){
        while(node != null){
            stack.add(node);
            node = node.left;
        }
    }
    
}
