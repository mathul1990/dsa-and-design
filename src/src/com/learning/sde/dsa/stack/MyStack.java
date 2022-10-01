package com.learning.sde.dsa.stack;

public class MyStack {

    int capacity;
    int[] stackArray;
    int top;

    MyStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    void push(int data) {
        if (top < capacity) {
            stackArray[++top] = data;
        } else {
            System.out.println("\n Stack full!!");
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("\n Stack Empty!!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println("\n Pop: " + myStack.pop());
        System.out.println("\n Pop: " + myStack.pop());
        System.out.println("\n Pop: " + myStack.pop());
    }
}
