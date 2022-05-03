package com.ds.binarysearchTree;

public class BST {

    private class Node {

        public Integer data;
        Node leftChild;
        Node rightChild;


        public Node() {}

        public Node(Integer data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(Integer data) {
        if(root == null) {
            root = new Node(data);
            return;
        }

        Node current = root;
        Node newNode = new Node(data);
        while(true) {
            if(data <= current.data) {
                if(current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                else {
                    current = current.leftChild;
                }
            }
            else {
                if(current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                else {
                    current = current.rightChild;
                }
            }
        }
    }

    public boolean find(Integer value) {
        if(root == null) {
            return false;
        }
        Node current = root;
        while(true) {
            if(current.data == value) {
                return true;
            }

            if(value < current.data) {
                if(current.leftChild == null) return false;
                current = current.leftChild;
            }
            else {
                if(current.rightChild == null) return false;
                current = current.rightChild;
            }
        }
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }


    public void preOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    public void postOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.data);
    }

    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    public void inOrderTraverse(Node node) {
        if(node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.println(node.data);
        inOrderTraverse(node.rightChild);
    }

    public int findHeight() {
        return findHeight(root);
    }

    public int findHeight(Node node) {
        if(node == null) {
            return -1;
        }

        if(node.leftChild == null && node.rightChild == null) {
            return 0;
        }

        return 1 + Math.max(findHeight(node.leftChild), findHeight(node.rightChild));
    }

    public boolean equals( BST second) {
        return equals(root, second.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null) {
            return true;
        }
        if(first != null && second != null) {
            return (first.data== second.data) && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(Node node, Integer min, Integer max) {
        if(node == null) return true;

        if(node.data < min || node.data > max) return false;

        return isValidBST(node.leftChild, min, node.data-1) && isValidBST(node.rightChild,min+1, node.data);
    }

    public void findAtKDistance(int dist) {
        findAtKDistance(root, dist);
    }
    private void findAtKDistance(Node node, int dist) {
        if(node == null) {
            return;
        }

        if(dist == 0) {
            System.out.println(node.data);
            return;
        }
        findAtKDistance(node.leftChild, dist-1);
        findAtKDistance(node.rightChild, dist-1);
    }

    public void traverseBFS() {
        int height = findHeight();
        for(int i=0; i<=height && height>=0;i++) {
            findAtKDistance(i);
        }
    }


}



