package dev.bosse.datastructures.tree;

/**
 * Represents a node in a binary search tree.
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
