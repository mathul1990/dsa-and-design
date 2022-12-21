package com.learning.sde.sdesheet.linkedlists;

public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
        head = null;
    }

    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addToEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = node;
    }

    public void print() {
        Node t = head;
        while(t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node node) {
        this.head = node;
    }

}
