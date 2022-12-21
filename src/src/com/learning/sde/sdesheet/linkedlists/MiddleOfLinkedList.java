package com.learning.sde.sdesheet.linkedlists;

public class MiddleOfLinkedList {

    private MyLinkedList myLinkedList;
    public MiddleOfLinkedList() {
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

    public int middle() {
        MyLinkedList.Node s = myLinkedList.getHead();
        MyLinkedList.Node f = myLinkedList.getHead();
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s.data;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        middleOfLinkedList.add(1);
        middleOfLinkedList.add(2);
        middleOfLinkedList.add(3);
        middleOfLinkedList.add(4);
        middleOfLinkedList.add(5);
        middleOfLinkedList.add(6);
        System.out.println("Linked List: ");
        middleOfLinkedList.print();
        int mid = middleOfLinkedList.middle();
        System.out.println("\nMiddle of Linked List: " + mid);
    }
}
