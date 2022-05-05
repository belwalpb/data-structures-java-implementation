package com.ds.primitiveArray;

public class Main {

    public static void main(String[] args) {
        //Run this in debug mode.
        ArrayProgram program = new ArrayProgram();
        program.insertAtLast(8); // [ 8 ]
        program.insertAtBeginning(15); // [ 15, 8 ]
        program.insertAtIndex(5,1); // [ 15, 5 , 8 ]
        program.reverse(); // [ 8, 5, 15 ]
        System.out.println("Done");
    }
}
