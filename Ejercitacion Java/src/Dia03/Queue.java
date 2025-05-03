package Dia03;
//import Dia02.Node;

public class Queue{
    private Node front, rear;

    private static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if (rear != null) {
            rear.next = node;
        }
        rear = node;
        if (front == null) {
            front = rear;
        }
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int result = front.data;
        front = front.next;
        if (front == null) rear = null;
        return result;
    }

    public boolean isEmpty() {
        return front == null;
    }
}