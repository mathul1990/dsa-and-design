package com.learning.sde.sdesheet.linkedlists;

import java.util.Stack;

public class AddTwoLinkedLists {

    public AddTwoLinkedLists() {
    }

    public void add(MyLinkedList myLinkedList, int data) {
        myLinkedList.addToEnd(data);
    }

    public void print(MyLinkedList myLinkedList) {
        myLinkedList.print();
    }

    /**
     * Add 2 linked lists and create a new linked list with sum.
     */
    public MyLinkedList addLinkedLists(MyLinkedList myLinkedList1, MyLinkedList myLinkedList2) {
        MyLinkedList.Node head1 = myLinkedList1.getHead();
        MyLinkedList.Node head2 = myLinkedList2.getHead();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(head1 != null) {
            stack1.add(head1.data);
            head1 = head1.next;
        }

        while(head2 != null) {
            stack2.add(head2.data);
            head2 = head2.next;
        }

        int s = 0;
        int r = 0;

        int size = Math.max(stack1.size(), stack2.size());
        int i = 0;

        MyLinkedList.Node newHead = null;
        MyLinkedList.Node temp = null;

        while(i<size) {
            int s1 = 0;
            int s2 = 0;
            if (!stack1.isEmpty()) {
                s1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                s2 = stack2.pop();
            }
            s = s1 + s2 + r;
            r = s/10;
            s = s%10;
            i++;
            if (newHead == null) {
                newHead = new MyLinkedList.Node(s);
                temp = newHead;
            } else {
                temp.next = new MyLinkedList.Node(s);
                temp = temp.next;
            }
        }
        if (r != 0) {
            temp.next = new MyLinkedList.Node(r);
        }
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.setHead(newHead);
        return myLinkedList;
    }

    public static void main(String[] args) {
        AddTwoLinkedLists mergeTwoSortedLinkedList = new AddTwoLinkedLists();
        MyLinkedList myLinkedList1 = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();
        mergeTwoSortedLinkedList.add(myLinkedList1, 2);
        mergeTwoSortedLinkedList.add(myLinkedList1,4);
        mergeTwoSortedLinkedList.add(myLinkedList1,3);
        mergeTwoSortedLinkedList.add(myLinkedList2,5);
        mergeTwoSortedLinkedList.add(myLinkedList2,6);
        mergeTwoSortedLinkedList.add(myLinkedList2,4);
//        mergeTwoSortedLinkedList.add(myLinkedList2,9);
        System.out.println("\nLinked List1: ");
        mergeTwoSortedLinkedList.print(myLinkedList1);
        System.out.println("\nLinked List2: ");
        mergeTwoSortedLinkedList.print(myLinkedList2);
        MyLinkedList addedLinkedList = mergeTwoSortedLinkedList.addLinkedLists(myLinkedList1, myLinkedList2);
        System.out.println("\nAdded Linked List: ");
        mergeTwoSortedLinkedList.print(addedLinkedList);
    }
}
