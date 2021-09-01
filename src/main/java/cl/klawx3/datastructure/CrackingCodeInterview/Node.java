package cl.klawx3.datastructure.CrackingCodeInterview;


public class Node {
    public int data;
    Node next = null;

    public Node(int data){
        this.data = data;
    }

    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public void printList(){
        Node n = this;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }

    }

    public boolean isPalindrome(){
        Node nodeReversed = clonedReverseList();
        Node nodeNormal = this;
        return isEquals(nodeReversed,nodeNormal);
    }

    public boolean isEquals(Node n1, Node n2){
        while(n1 != null){
            if(n1.data != n2.data){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    public Node clonedReverseList(){
        Node node = this;
        Node lastInsertedNode = null;
        while(node != null){
            Node newNode = new Node(node.data);
            newNode.next = lastInsertedNode;
            lastInsertedNode = newNode;
            node = node.next;
        }
        return lastInsertedNode;

    }
}
