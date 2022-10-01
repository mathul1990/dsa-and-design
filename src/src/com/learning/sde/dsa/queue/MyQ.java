package com.learning.sde.dsa.queue;

public class MyQ {
    int capacity;
    int[] qArray;
    int front;
    int rear;
    int size = 0;

    MyQ(int capacity) {
        this.capacity = capacity;
        this.qArray = new int[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    void enQ(int data) {
        if (size >= capacity) {
            System.out.println("\n Q full!!");
        } else {
            qArray[++rear] = data;
            size++;
        }
    }

    int deQ() {
        if (size == 0) {
            System.out.println("\n Q empty!!");
            return -1;
        } else {
            int value = qArray[++front];
            size--;
            return value;
        }
    }

    public static void main(String[] args) {
        MyQ myQ = new MyQ(5);
        myQ.enQ(1);
        myQ.enQ(2);
        myQ.enQ(3);
        myQ.enQ(4);
        myQ.enQ(5);
        myQ.enQ(6);
        System.out.println("\n De Q: " + myQ.deQ());
        System.out.println("\n De Q: " + myQ.deQ());
    }
}
