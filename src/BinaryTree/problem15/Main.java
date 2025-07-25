package BinaryTree.problem15;

import java.util.*;

// TreeNode as defined
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// LCA
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null) return root;
        if(right==null) return left; //dont just write root.right otherwise it will check only right child of root
        else return right;
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
        TreeNode node4 = root.left;
        TreeNode node8 = root.right.left;
        // [return type] [variable] = sol.[function name(pass arg)];
        TreeNode ans = sol.lowestCommonAncestor(root,node4,node8);

        // Print result
        System.out.println(ans.val);
    }
}
