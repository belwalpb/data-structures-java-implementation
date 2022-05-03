package com.ds.avlTree;

public class Main {
    public static void main(String[] args) {
        AVLTree tree= new AVLTree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(8);
        tree.insert(13);
        tree.insert(15);
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);
        System.out.println("Done");
    }
}
