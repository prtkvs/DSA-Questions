package BinaryTree.problem9;

import java.util.*;

// TreeNode as defined
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Diameter
class Solution {
    int diameter = 0; //common variable for height and diameterOfBinaryTree
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    public int height(TreeNode node){
        if(node==null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        int dia = left + right + 1;
        diameter = Math.max(dia,diameter);
        return Math.max(left,right)+1;
    }
}
public class Main {
    public static void main(String[] args) {
        // Manually constructing the tree in the image:
        //       3
        //      / \
        //     9  20
        //    /   / \
        //   11  15  7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(11);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Call Solution
        Solution sol = new Solution();
        // [return type] [variable] = sol.[function name(pass arg)];
        int ans = sol.diameterOfBinaryTree(root);

        // Print result
        System.out.println(ans);
    }
}