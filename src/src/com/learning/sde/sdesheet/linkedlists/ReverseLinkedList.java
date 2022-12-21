package com.learning.sde.sdesheet.linkedlists;

public class ReverseLinkedList {

    private MyLinkedList myLinkedList;
    public ReverseLinkedList() {
        myLinkedList = new MyLinkedList();
    }

    public void add(int data) {
        myLinkedList.addToEnd(data);
    }

    public void print() {
        myLinkedList.print();
    }

    public void setHead(MyLinkedList.Node node) {
        myLinkedList.setHead(node);
    }

    public MyLinkedList.Node reverse() {
        MyLinkedList.Node current = myLinkedList.getHead();
        MyLinkedList.Node prev = null;
        MyLinkedList.Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.add(1);
        reverseLinkedList.add(2);
        reverseLinkedList.add(3);
        reverseLinkedList.add(4);
        reverseLinkedList.add(5);
        System.out.println("Linked List: ");
        reverseLinkedList.print();
        MyLinkedList.Node newHead = reverseLinkedList.reverse();
        reverseLinkedList.setHead(newHead);
        System.out.println("\nReversed Linked List: ");
        reverseLinkedList.print();
    }
}
