package cl.klawx3.datastructure.tree;


public class Tree {
    Node baseNode;

    public void add(int value){
        Node newNode = new Node(value);
        if(baseNode == null){
            baseNode = newNode;
        }else{
            add(newNode,baseNode);
        }
    }

    private void add(Node newNode,Node baseNode){
        
        if(newNode.value > baseNode.value){
            if(baseNode.right == null){
                baseNode.right = newNode;
            }else{
                add(newNode,baseNode.right);
            }
        }else if(newNode.value < baseNode.value){
            if(baseNode.left == null){
                baseNode.left = newNode;
            }else{
                add(newNode,baseNode.left);
            }
        }


            
    }

    public boolean existNumber(int number){
        return existNumber(number,baseNode);
    }

    private boolean existNumber(int number, Node baseNode){
        if (baseNode == null) return false;
        if (baseNode.value == number) return true;

        if(number < baseNode.value){
            return existNumber(number, baseNode.left);
        }else{
            return existNumber(number, baseNode.right);
        }

    }

    public void preOrder() {
        preOrder(baseNode);        
    }

    private void preOrder(Node node) {
        if(node== null) return;
        System.out.println(node.value);
        preOrder(node.left);        
        preOrder(node.right);
    }


    
}
