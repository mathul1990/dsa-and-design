package com.learning.sde.sdesheet.linkedlists;

public class MergeTwoSortedLinkedList {

    public MergeTwoSortedLinkedList() {
    }

    public void add(MyLinkedList myLinkedList, int data) {
        myLinkedList.addToEnd(data);
    }

    public void print(MyLinkedList myLinkedList) {
        myLinkedList.print();
    }

    public MyLinkedList.Node merge(MyLinkedList myLinkedList1, MyLinkedList myLinkedList2) {
        MyLinkedList.Node head1 = myLinkedList1.getHead();
        MyLinkedList.Node head2 = myLinkedList2.getHead();

        int h;
        if (head1.data < head2.data) {
            h = head1.data;
            head1 = head1.next;
        } else {
            h = head2.data;
            head2 = head2.next;
        }
        MyLinkedList.Node head3 = new MyLinkedList.Node(h);
        MyLinkedList.Node t = head3;

        while (head1 != null && head2 != null) {
            int temp;
            if (head1.data < head2.data) {
                temp = head1.data;
                head1 = head1.next;
            } else {
                temp = head2.data;
                head2 = head2.next;
            }
            t.next = new MyLinkedList.Node(temp);
            t = t.next;
        }

        while (head1 != null) {
            t.next = new MyLinkedList.Node(head1.data);
            head1 = head1.next;
            t = t.next;
        }
        while (head2 != null) {
            t.next = new MyLinkedList.Node(head1.data);
            head2 = head2.next;
            t = t.next;
        }
        return head3;
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
        MyLinkedList myLinkedList1 = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();
        mergeTwoSortedLinkedList.add(myLinkedList1, 1);
        mergeTwoSortedLinkedList.add(myLinkedList2,2);
        mergeTwoSortedLinkedList.add(myLinkedList1,3);
        mergeTwoSortedLinkedList.add(myLinkedList2,4);
        mergeTwoSortedLinkedList.add(myLinkedList1,5);
        mergeTwoSortedLinkedList.add(myLinkedList2,6);
        mergeTwoSortedLinkedList.add(myLinkedList1,7);
        System.out.println("\nLinked List1: ");
        mergeTwoSortedLinkedList.print(myLinkedList1);
        System.out.println("\nLinked List2: ");
        mergeTwoSortedLinkedList.print(myLinkedList2);
        MyLinkedList.Node mergedNode = mergeTwoSortedLinkedList.merge(myLinkedList1, myLinkedList2);
        MyLinkedList mergedLinkedList = new MyLinkedList();
        mergedLinkedList.setHead(mergedNode);
        System.out.println("\nMerged Linked List: ");
        mergeTwoSortedLinkedList.print(mergedLinkedList);
    }
}
