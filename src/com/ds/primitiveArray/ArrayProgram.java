package com.ds.primitiveArray;

public class ArrayProgram {

    int[] arr = new int[50];
    int currentSize = 0;


    /**
     *
     * @param item the item that we want to search in array
     * @return true if item is found otherwise false.
     */
    public boolean contains(int item) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==item)
                return true;
        }
        return false;
    }

    /**
     * This method will reverse the array.
     */
    public void reverse() {
        for(int i=0,j=currentSize-1;i<j;i++,j--) {
            swap(i, j);
        }
    }

    /**
     * Helper method to swap two items in array
     * @param i, first index
     * @param j, second index
     */
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * This method will insert a new item at the beginning of the array
     * @param item
     */
    public void insertAtBeginning(int item) {
        insertAtIndex(item,0);
    }

    /**
     * This method will insert an item into given position in the array.
     * @param item
     * @param index
     */
    public void insertAtIndex(int item, int index) {
        // Checking if array if full or not.
        if(currentSize == arr.length) {
            throw new IllegalStateException("The array capacity is full now");
        }

        // If array is not full, then shifting all the elements from the index to last item.
        for(int i=currentSize-1;i>=index;i--) {
           arr[i+1] = arr[i];
        }

        // Inserting the item at the given position.
        arr[index] = item;
        currentSize++;
    }

    /**
     * This method will insert the item in the array at last position.
     * @param item
     */
    public void insertAtLast(int item) {
        // Checking if array if full or not.
        if(currentSize == arr.length) {
            throw new IllegalStateException("The array capacity is full now");
        }
        arr[currentSize++] = item;
    }
}
