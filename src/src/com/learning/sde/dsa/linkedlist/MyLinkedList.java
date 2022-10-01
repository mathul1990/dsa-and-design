package com.learning.sde.dsa.linkedlist;

public class MyLinkedList {

    Node head = null;

    class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        Node temp = new Node(data);
        if (this.head == null) {
            this.head = temp;
            return;
        }

        Node h = this.head;
        while(h.next != null) {
            h = h.next;
        }
        h.next = temp;
    }

    public void print() {
        Node h = this.head;
        while(h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
    }

    void del(int data) {
        Node p = head;
        Node t = head;

        while (t != null && t.data != data) {
            p = t;
            t = t.next;
        }
        p.next = t.next;
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.insert(8);
        linkedList.insert(9);

        linkedList.print();
        System.out.println("\nAfter deletion:");
        linkedList.del(5);
        linkedList.print();
    }
}
