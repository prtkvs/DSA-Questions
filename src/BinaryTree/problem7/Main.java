package BinaryTree.problem7;

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

// Cousins
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode X = findNode(root,x);
        TreeNode Y = findNode(root, y);
        return (    // same level and not siblings
                level(root,X,0)==level(root,Y,0) && !isSibling(root,X,Y)
        );
    }

    TreeNode findNode(TreeNode node, int x){
        if(node==null) return node;
        if(node.val==x) return node;
        TreeNode n = findNode(node.left,x);
        if(n!=null) return n;
        return findNode(node.right,x);
    }

    int level(TreeNode node, TreeNode x, int lev){
        if(node==null) return 0;
        if(node==x) return lev;
        int l = level(node.left,x,lev+1);
        if(l!=0){
            return l;
        }
        return level(node.right,x,lev+1);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if(node==null) return false;
        return (
                (node.left==x && node.right==y) || (node.left==y && node.right==x)
                        || isSibling(node.left,x,y) || isSibling(node.right,x,y)
        );
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

        // Call BFS
        Solution sol = new Solution();
        // [return type] [variable] = sol.[function name(pass arg)];
        boolean ans = sol.isCousins(root,11,15);

        // Print result
        if(ans){
            System.out.println("Cousins");
        }else{
            System.out.println("Not Cousins");
        }
    }
}