package com.ds.avlTree;

public class AVLTree {
    private class  AVLNode {
        public Integer data;
        public AVLNode leftChild;
        public AVLNode rightChild;
        private Integer height=0;
        public AVLNode() {}
        public AVLNode(Integer data) {
            this.data = data;
        }
    }

    private AVLNode root;
    public void insert(int value) {
        root =insert(root,value);
    }

    private AVLNode insert(AVLNode node, int value) {
        if(node== null) {
            return new AVLNode(value);
        }

        if(value < node.data) {
            node.leftChild = insert(node.leftChild, value);
        }
        else {
            node.rightChild = insert(node.rightChild, value);
        }

        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        // Check the Balance Factor = height(left) - height(right)
        // > 1 Left Heavy Tree
        // < -1 Right Heavy
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1) {
            //If Tree is Left Heavy
            System.out.println(node.data + " is Left Heavy");
            if(node.leftChild.leftChild != null) {
                node = doRightRotation(node);
            }
            else {
                node.leftChild = doLeftRotation(node.leftChild);
                node = doRightRotation(node);
            }
        }
        else if(balanceFactor < -1) {
            System.out.println(node.data + " is Right Heavy");
            if(node.rightChild.rightChild != null) {
                node = doLeftRotation(node);
            }
            else {
                node.rightChild = doRightRotation(node.rightChild);
                node = doLeftRotation(node);
            }
        }

        return node;
    }

    private AVLNode doLeftRotation(AVLNode node) {
        AVLNode temp = node.rightChild;
        node.rightChild = temp.leftChild;
        temp.leftChild = node;
        node = temp;
        node.leftChild.height = getHeightFromChilds(node.leftChild);
        node.height = getHeight(node);
        return node;
    }

    private AVLNode doRightRotation(AVLNode node) {
        AVLNode temp = node.leftChild;
        node.leftChild = temp.rightChild;
        temp.rightChild = node;
        node = temp;
        node.rightChild.height = getHeightFromChilds(node.rightChild);
        node.height = getHeight(node);
        return node;
    }

    private int getHeight(AVLNode node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }
    private int getHeightFromChilds(AVLNode node) {
        return Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

    private int getBalanceFactor(AVLNode node) {
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }
}

