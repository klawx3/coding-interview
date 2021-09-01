package cl.klawx3.datastructure.list;

import java.util.HashMap;
import java.util.Iterator;

public class SingleLinkedList implements Iterator<Integer>,Iterable<Integer>{
    private final static int EMPTY = -1;
    private Node startNode;
    private Node iteratorPointer;
    private boolean firstCall;
    private int length;

    
    public void appendTotal(int data){
        Node node = new Node(data);
        if(startNode != null){
            node.nextNode = startNode;
        }
        startNode = node;
        incrementDataCount();
    }

    public void appendToFront(int data){
        Node node = new Node(data);
        Node currentNode = startNode;
        incrementDataCount();
        if(currentNode == null){
            startNode = node;
            return;
        }

        while(currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = node;
        
    }

    private void incrementDataCount(){
        length++;
    }


    public void printList(){
        Node actualNode = startNode;
        while(actualNode != null){
            System.out.print(actualNode.data + " ");
            actualNode = actualNode.nextNode;
        }
        System.out.println();
    }

    @Override
    public boolean hasNext() {
        return iteratorPointer != null;
    }

    @Override
    public Integer next() {
        int data = iteratorPointer.data;
        iteratorPointer = iteratorPointer.nextNode;
        return data;
    }

    @Override
    public Iterator iterator() {
        iteratorPointer = startNode;
        return this;
    }

    public void deleteDuplicatesElements() {
        HashMap<Integer,Boolean> hp = new HashMap<>();
        Node actualNodeI = startNode; 
        hp.put(actualNodeI.data, true);
        while(actualNodeI != null && actualNodeI.nextNode != null){
            if(hp.get(actualNodeI.nextNode.data) != null){ // elimino
                actualNodeI.nextNode = actualNodeI.nextNode.nextNode;
                continue;
            }else{
                hp.put(actualNodeI.nextNode.data, true);
            }
            actualNodeI = actualNodeI.nextNode;
        }
    }

    public void deleteDuplicateElementsNoBuffer(){
        Node iNode,jNode;
        iNode = jNode = startNode;

        while(iNode != null){
            jNode = iNode;
            while(jNode != null){
                if(jNode.nextNode != null){
                    if(iNode.data == jNode.nextNode.data){
                        jNode.nextNode = jNode.nextNode.nextNode;
                        continue;
                    }
                }
                jNode = jNode.nextNode;
            }
            iNode = iNode.nextNode;
        }
    }

    public void deleteNode(int position){
        Node actualNode = startNode;

        if(position == 0 && actualNode != null){
            startNode = actualNode.nextNode;
            return;
        }
        
        for(int i = 1 ; actualNode.nextNode != null ; i++, actualNode = actualNode.nextNode){
            if(i == position){
                actualNode.nextNode  = actualNode.nextNode.nextNode;
                return;
            }
        }
    }

    public void deleteNodeByValue(int value){
        Node actualNode = startNode;

        if(actualNode != null && actualNode.data == value){
            startNode = actualNode.nextNode;
        }

        while(actualNode.nextNode != null){
            if(actualNode.nextNode.data == value){
                actualNode.nextNode = actualNode.nextNode.nextNode;
                return;
            }
            actualNode = actualNode.nextNode;
        }
    }

    public int get_Nth_LastElement(int i) {
        return -1;
    }

    private int count(){
        int count = 0;
        Node n = startNode;
        while(n != null){
            count++;
            n = n.nextNode;
        }
        return count;
    }

    public Node getNode(int pos){
        Node n = startNode;
        int count = 0;
        while(n != null){
            if(count == pos)
                break;

            n = n.nextNode; count++;
        }
        return n;
    }

    public void deleteNode(Node middleNode) {
        Node n = middleNode;
        while(n != null){
            if(n.nextNode  != null){
                n.data = n.nextNode.data;
            }
            if(n.nextNode.nextNode == null){
                n.nextNode = null;
            }           
            n = n.nextNode;
        }
    }

    public void deleteMiddleNode() {
        int middleNode = count() / 2 - 1;
        Node n = startNode;
        int nodeCount = 0;
        if(middleNode == 0){
            startNode = startNode.nextNode;
        }else{
            while(true){
                if(nodeCount + 1 == middleNode ){
                    n.nextNode = n.nextNode.nextNode;
                    break;
                }
                n = n.nextNode;
                nodeCount++;
            }
        }
    }

    public void deleteMiddleNodeUsing3Pointers(){
        Node slowPointer = startNode.nextNode;
        Node backNode = startNode;
        Node fastPointer = startNode.nextNode.nextNode;
        

        while(fastPointer != null){
            if(fastPointer.nextNode != null){
                fastPointer = fastPointer.nextNode.nextNode;
                if(fastPointer == null){
                    break;
                }
            }else{
                break;
            }

            backNode = backNode.nextNode;
            slowPointer = slowPointer.nextNode;
        }

        backNode.nextNode = slowPointer.nextNode; // delete

    }

    public boolean isListAPalindrome(){
        Node node = startNode;
        return true;
    }

    public void partionListArround(int partitionNumber) {
        Node leftStartNode = null;
        Node leftEndNode = null;

        Node rightStartNode = null;
        Node rightEndNode = null;

        Node n = startNode;
        while(n != null){
            if(n.data < partitionNumber){ // left
                if(leftStartNode == null){
                    leftStartNode = leftEndNode = n;
                }else{
                    leftEndNode.nextNode = n;
                    leftEndNode = leftEndNode.nextNode;
                }
            }else{ // right
                if(rightStartNode == null){
                    rightStartNode = rightEndNode = n;
                }else{
                    rightEndNode.nextNode = n;
                    rightEndNode = rightEndNode.nextNode;
                }
            }
            n = n.nextNode;
        }
        
        startNode = leftStartNode;
        leftEndNode.nextNode = rightStartNode;
        rightEndNode = null;
        
    }
    
}
