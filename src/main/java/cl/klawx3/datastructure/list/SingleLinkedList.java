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
            }else{
                hp.put(actualNodeI.nextNode.data, true);
            }
            actualNodeI = actualNodeI.nextNode;
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
    
}
