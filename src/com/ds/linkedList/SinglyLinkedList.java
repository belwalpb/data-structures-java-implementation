package com.ds.linkedList;

public class SinglyLinkedList {
    private class Node {
        Integer data;
        Node next;
        Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private int size = 0;

    public void insertAtBeginning(int data) {
        if(head == null) {
            head = new Node(data, null);
        }
        else {
            head  = new Node(data, head);
        }
        size++;
    }

    public void insertAtLast(int data) {
        insertAtIndex(data, size);
    }

    public void deleteFromBeginning() {
        if(head == null) {
            throw new IllegalStateException("The Linked List is already empty.");
        }
        head = head.next;
        size--;
    }

    public void deleteAtEnd() {
        if(head == null) {
            throw new IllegalStateException("The Linked List is already empty.");
        }
        // If there is only one item in linked list, then deleting the first item
        if(head.next == null) {
            head = null;
            size--;
        }
        //Otherwise iterating through the list
        Node currentNode = head;

        //Loop will findout the second last element for us
        while(currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        //Here currentNode variable will have second last element.
        currentNode.next = null;
        size--;
    }

    public void deleteAtIndex(int index) {
        // If List is empty or index is greater than the elements in the list then throwing exception.
        if(size==0 || index >=size) {
            throw new IllegalStateException("The Given Index "+index + " does not holds any data.");
        }
        //If We have to delete first element then, calling deleteFromBeginning() method.
        if(index ==0) {
            deleteFromBeginning();
            return;
        }

        // If we have to delete second element, then making third element as the next of first element.
        if(index ==1) {
         head.next = head.next.next;
         size--;
        }

        int currentIndex =0;
        Node currentNode = head;
        while(currentIndex != index-1) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        //At this point, our variable currentNode will contain (index-1) node. So
        currentNode.next = currentNode.next.next;
        size--;
    }

    public void insertAtIndex(int data, int index) {
        // Case when head is null and we want to add first element
        if(head==null && index==0) {
            this.head = new Node(data, null);
            size++;
            return;
        }

        if(index ==0) {
            insertAtBeginning(data);
            return;
        }

        // Otherwise when there is some elements in linked list and we want to add new.

        //Iterating through the list and finding the correct index to insert.
        int currentNodeIndex = 0;
        Node prevNode = null;
        Node currentNode = head;

        // Loop can be breaked by two reasons. 1. We found the index, in which we want to insert new element
        // 2. We reached at the end of linked list, but did not found the required index.
        while(currentNodeIndex != index) {
            if(currentNode.next !=null) {
                currentNodeIndex++;
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            else {
                break;
            }
        }

        // If Loop is breaked by Reason 1: i.e. We found the index at which the element have to be inserted.
        if(index == currentNodeIndex) {
            Node newNode = new Node(data, currentNode);
            prevNode.next = newNode;
            size++;
            return;
        }

        //If currentIndex = 5 and index = 6. It means we are going to insert new item at last.
        if(currentNodeIndex == index-1) {
            currentNode.next = new Node(data, null);
            size++;
            return;
        }

        // If none of the cases are matching it means we want to insert a new node at some invalid position.
        throw new IllegalStateException("index "+ index + " is not a valid index to be inserted");
    }


    public void reverse() {
        //If there are no items in the list or only one item then don't do anything.
        if(head==null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currentNode = head.next;
        Node nextNode = currentNode.next;

        head.next = null;

        while(nextNode !=null) {
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode  = nextNode;
            nextNode = nextNode.next;
        }

        currentNode.next = prevNode;
        head = currentNode;

    }

    public boolean contains(int item) {
        if(head == null) {
            return false;
        }
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.data == item) {
                return true;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
