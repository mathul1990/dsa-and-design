package com.learning.sde.dsa.tree;

public class MyTree {
    Node root = null;
    class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            right = left = null;
        }
    }

    Node insert(Node root, int data) {
        if (root == null) {
            Node node = new Node(data);
            return node;
        }

        if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.root = tree.insert(tree.root, 100);
        tree.root = tree.insert(tree.root, 75);
        tree.root = tree.insert(tree.root, 200);
        tree.root = tree.insert(tree.root, 150);
        tree.root = tree.insert(tree.root, 250);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 90);

        tree.inorder(tree.root);
    }
}
