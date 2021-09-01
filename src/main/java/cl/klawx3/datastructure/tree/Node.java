package cl.klawx3.datastructure.tree;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "Node [left=" + left + ", right=" + right + ", value=" + value + "]";
    }
}
