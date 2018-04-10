package com.m3c.ajfr.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeImpl implements BinaryTree {
    private final Node root;
    private int binaryTreeSize;

    public BinaryTreeImpl(int value){
        root = new Node(value);
        binaryTreeSize = 1;
    }

    public BinaryTreeImpl(int[] treeArray){
        root = new Node(treeArray[0]);
        int[] treeArrayNoRoot = new int[treeArray.length-1];
        binaryTreeSize = 1;
        System.arraycopy(treeArray,1,treeArrayNoRoot,0,treeArray.length-1);
        addElements(treeArrayNoRoot);
    }

    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return binaryTreeSize;
    }

    /*@Override
    public void addElement(int element) {
        Node currentNode = root;
        Node elementToAdd = new Node(element);
        boolean added = findElement(element);
        while(!added) {
            if (element > currentNode.getValue()) {
                if(currentNode.getRightChild()!=null){
                    currentNode = currentNode.getRightChild();
                }
                else{
                    currentNode.setRightChild(elementToAdd);
                    added = true;
                    binaryTreeSize++;
                }

            }
            else if (element < currentNode.getValue()){
                if(currentNode.getLeftChild()!=null){
                    currentNode = currentNode.getLeftChild();
                }
                else{
                    currentNode.setLeftChild(elementToAdd);
                    added = true;
                    binaryTreeSize++;
                }
            }
        }

    }*/

    @Override
    public void addElement(int element){
        addElementRec(element, root);
    }

    public void addElementRec(int element, Node currentNode){
        if(element<currentNode.getValue()){
            if(currentNode.getLeftChild()==null){
                currentNode.setLeftChild(new Node(element));
                binaryTreeSize++;
            }
            else{
                addElementRec(element, currentNode.getLeftChild());
            }
        }
        else {
            if(currentNode.getRightChild()==null){
                currentNode.setRightChild(new Node(element));
                binaryTreeSize++;
            }
            else{
                addElementRec(element, currentNode.getRightChild());
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int elementToAdd: elements) {
            addElement(elementToAdd);
        }
    }

    @Override
    public boolean findElement(int value) {
        Node currentNode = root;
        while(currentNode!=null){
            if(currentNode.getValue()==value){
                return true;
            }
            else{
                if(currentNode.getValue()>value){
                    currentNode = currentNode.getLeftChild();
                }
                else if(currentNode.getValue()<value){
                    currentNode = currentNode.getRightChild();
                }
            }
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ElementNotFoundException {
        Node currentNode = root;
        while(currentNode!=null){
            if(currentNode.getValue()==element){
                if(currentNode.getLeftChild()!=null) {
                    return currentNode.getLeftChild().getValue();
                }
                else{
                    throw new ElementNotFoundException();
                }
            }
            else{
                if(currentNode.getValue()>element){
                    currentNode = currentNode.getLeftChild();
                }
                else if(currentNode.getValue()<element){
                    currentNode = currentNode.getRightChild();
                }
            }
        }
        throw new ElementNotFoundException();
    }

    @Override
    public int getRightChild(int element) throws ElementNotFoundException {
        Node currentNode = root;
        while(currentNode!=null){
            if(currentNode.getValue()==element){
                if(currentNode.getRightChild()!=null) {
                    return currentNode.getRightChild().getValue();
                }
                else{
                    throw new ElementNotFoundException();
                }
            }
            else{
                if(currentNode.getValue()>element){
                    currentNode = currentNode.getLeftChild();
                }
                else if(currentNode.getValue()<element){
                    currentNode = currentNode.getRightChild();
                }
            }
        }
        throw new ElementNotFoundException();
    }

    @Override
    public List<Integer> getSortedTreeAsc() {
        List<Integer> sortedTreeAsc = new ArrayList<>();
        Stack<Node> treeStack = new Stack<>();
        Node currentNode = root;
        while (!treeStack.empty() || currentNode != null) {
            if(currentNode!=null){
                treeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            else {
                Node tempNode = treeStack.pop();
                sortedTreeAsc.add(tempNode.getValue());
                currentNode = tempNode.getRightChild();
            }
        }
        return sortedTreeAsc;
    }

    @Override
    public List<Integer> getSortedTreeDesc() {
        List<Integer> sortedTreeAsc = new ArrayList<>();
        Stack<Node> treeStack = new Stack<>();
        Node currentNode = root;
        while (!treeStack.empty() || currentNode != null) {
            if(currentNode!=null){
                treeStack.push(currentNode);
                currentNode = currentNode.getRightChild();
            }
            else {
                Node tempNode = treeStack.pop();
                sortedTreeAsc.add(tempNode.getValue());
                currentNode = tempNode.getLeftChild();
            }
        }
        return sortedTreeAsc;
    }

}

