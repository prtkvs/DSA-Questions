package BinaryTree.problem14;

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

// Validate BST
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode node, Integer low, Integer high){
        if(node==null) return true;
        if(low!=null && node.val<=low){
            return false;
        }
        if(high!=null && node.val>=high){
            return false;
        }
        boolean left = helper(node.left,low,node.val);
        boolean right = helper(node.right,node.val,high);
        return left&&right;
    }
}
public class Main {
    public static void main(String[] args) {
        // Manually constructing the tree in the image:
        //       6
        //      / \
        //     4   10
        //    / \  / \
        //   2  5 8  20

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(20);

        // Call Solution
        Solution sol = new Solution();
        // [return type] [variable] = sol.[function name(pass arg)];
        boolean ans = sol.isValidBST(root);

        // Print result
        System.out.println(ans);
    }
}
