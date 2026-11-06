package dev.bosse.datastructures.tree;

/**
 * BinarySearchTree class represents a binary search tree data structure.
 */
public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Returns the root node of the binary search tree.
     *
     * @return the root node
     */
    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * Inserts a new node with the given value into the binary search tree.
     *
     * @param root the root node of the binary search tree
     * @param value the value to be inserted
     * @return the root node of the binary search tree after insertion
     */
    TreeNode insertTreeNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insertTreeNode(root.left, value);
        } else {
            root.right = insertTreeNode(root.right, value);
        }

        return root;
    }

    public void insert(int value) {
        this.root = insertTreeNode(this.root, value);
    }



    private int minValue(TreeNode root) {
        int min = root.value;
        if (root.left == null) return min;
        while (root.left != null) {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }

    /**
     * Deletes a node with the given value from the binary search tree.
     *
     * @param root the root node of the binary search tree
     * @param value the value to be deleted
     * @return the root node of the binary search tree after deletion
     */
    TreeNode deleteTreeNode(TreeNode root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = deleteTreeNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteTreeNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            int min = minValue(root.right);
            root.value = min;
            root.right = deleteTreeNode(root.right, min);
        }

        return root;
    }

    public void delete(int value) {
        this.root = deleteTreeNode(this.root, value);
    }

    /**
     * Searches for a node with the given value in the binary search tree.
     *
     * @param root the root node of the binary search tree
     * @param value the value to be searched
     * @return true if the value is found, false otherwise
     */
    boolean searchTreeNode(TreeNode root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (value < root.value) return searchTreeNode(root.left, value);
        return searchTreeNode(root.right, value);
    }

    public boolean search(int value) {
        return searchTreeNode(this.root, value);
    }
}
