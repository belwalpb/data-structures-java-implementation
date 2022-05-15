package com.ds.linkedList;

public class SinglyMain {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10); // 10
        list.insertAtBeginning(20); // 20 -> 10
        list.insertAtBeginning(30); // 30 -> 20 ->10
        list.insertAtBeginning(40); // 40 -> 30 -> 20 ->10
        list.insertAtIndex(50,2); // 40 -> 30 -> 50 ->20 ->10
        list.insertAtLast(60); // 40 -> 30 -> 50 ->20 ->10->60
        list.deleteFromBeginning();//  30 -> 50 ->20 ->10->60
        list.deleteAtEnd();//  30 -> 50 ->20 ->10
        list.deleteAtIndex(2);//  30 -> 50 ->10
        list.reverse(); //10->50->30
        System.out.println("Program Executed Successfully");
    }
}
