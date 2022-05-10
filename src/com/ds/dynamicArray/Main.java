package com.ds.dynamicArray;

public class Main {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        System.out.println(arr); // [ ]
        arr.insert(5);
        arr.insert(12);
        arr.insert(8);
        System.out.println(arr); // [5, 12,8]

        System.out.println("Does Array Contains 12 : " +arr.contains(12)); // true
        System.out.println("Does Array Contains 50 : " +arr.contains(50)); // false

        System.out.println("Element at Index 1 in array is : " + arr.get(1));

    }
}
