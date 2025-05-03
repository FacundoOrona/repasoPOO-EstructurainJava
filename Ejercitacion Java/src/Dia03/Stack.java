package Dia03;
//import Dia02.Node;

public class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop(){
        if (top == null) throw new RuntimeException("Stack es vacio");
        int result = top.data;
        top = top.next;
        return result;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
