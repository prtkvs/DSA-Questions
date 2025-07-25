package BinaryTree.problem16.NotOptimised;

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

// Kth Smallest in BST
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> q = new LinkedList<>();
        inorder(root,q);
        int n = q.size(); //must since queue size is changing after poll
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = q.poll();
        }
        return arr[k-1];
    }
    public void inorder(TreeNode root, Queue<Integer> q){
        if(root==null) return ;
        inorder(root.left,q);
        q.add(root.val);
        inorder(root.right,q);
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
        int ans = sol.kthSmallest(root,2);

        // Print result
        System.out.println(ans);
    }
}
