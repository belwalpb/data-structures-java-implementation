package com.ds.heaps;

public class Heap {
    private int[] items = new int[10];
    private int size = 0;

    public void insert(int value) {
        if(size == items.length) {
            throw new IllegalStateException("Size of Array is already full");
        }

        int index = size++;

        items[index] = value;


        while((index>0) && (items[index] > items[getParentIndex(index)])) {
            swap(index,getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int getParentIndex(int index) {
        return (index-1)/2;
    }

    private void swap(int firstIndex, int secondIndex) {
       int temp = items[firstIndex];
       items[firstIndex] = items[secondIndex];
       items[secondIndex] = temp;
    }

    public void remove() {
        if(isEmpty()) {
            throw new IllegalStateException("Heap is already empty");
        }
        items[0] = items[--size];
        var index =0;
        while(!isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        return (items[index] > leftChild(index)) && (items[index] > rightChild(index));
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }
    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }
    private int leftChildIndex(int index) {
        return index*2+1;
    }
    private int rightChildIndex(int index) {
        return index*2+2;
    }
}
