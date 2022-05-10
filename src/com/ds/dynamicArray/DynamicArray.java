package com.ds.dynamicArray;

import java.util.Arrays;

public class DynamicArray {

    private int[] array = new int[5];
    private int maxSize = 5;
    private int currentSize = 0;

    public void insert(int newNum) {
        if(currentSize < maxSize) {
            array[currentSize] = newNum;
            currentSize++;
            return; //method end
        }
        // If we reach at this point, it means array is full, and we need to expand it.
        int newSize = getNewCapacity();
        int[] newArray = new int[newSize];
        //Copy Items from old array to new array
        for(int i=0;i<currentSize;i++) {
            newArray[i] = array[i];
        }
        // After copying old items, inserting new item.
        newArray[currentSize++] =newNum;
        // Setting array variable reference to newly created Array.
        array = newArray;
        maxSize = newSize;
    }

    /**
     * This method will return the array element at index i. it is same as accessing element like array[index]
     * @param index
     * @return data at position : index
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * This method will calculate the new size of array
     * @return new size of array after expanding
     */
    private int getNewCapacity() {
        // Each time, when resizing will be required, we will increase the size of array by 50%
        return (int) (maxSize*1.5);

    }

    /**
     * This method will return the current size of array i.e. currently filled elements
     * @return current size of array
     */
    public int size() {
        return currentSize;
    }

    /**
     * This method will check in the array if element is present or not.
     * @param itemToBeSearched The item which have to be searched
     * @return true if item is found otherwise false
     */
    public boolean contains(int itemToBeSearched) {
        // Iterating through array and finding the item. If item is found then it will immediately stop the loop and
        // will return true. Otherwise it will return false.
        for(int i=0;i<currentSize;i++) {
            if(array[i] == itemToBeSearched)
                return true;
        }

        return false;
    }

    /**
     * Method used to print array
     * @return String representation of array
     */
    @Override
    public String toString() {
        int[] tempArr = new int[currentSize];
        for(int i=0;i<currentSize;i++) {
            tempArr[i] = array[i];
        }
        return Arrays.toString(tempArr);
    }

}

