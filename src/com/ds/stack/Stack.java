package com.ds.stack;

public class Stack {

    private int[] arr;
    int top = -1;

    public Stack() {
        this.arr = new int[10];
    }

    public void push(int item) {
        if(isFull()) {
            throw new IllegalStateException("Stack is already full.");
        }
        arr[++top] = item;
    }

    public int pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is already empty");
        }
        return arr[top--];
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is already empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length-1;
    }
}
