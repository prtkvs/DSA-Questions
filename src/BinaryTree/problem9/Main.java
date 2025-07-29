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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    public int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        //firstly goes to the leftmost leaf(11) that will return height=0, left =0;
        int right = height(node.right);
        // jab return 0 hua from left then check it's right also null therefore, right=0
        diameter = Math.max(diameter, left + right); // (0,0+0) -> 0
        return Math.max(left, right) + 1;   // height(11) = 0+1 =1
    } // left - right - node = post order traversal
    // ab return hoga to aage ka check mt karna values jo mile usse leke piche jao
    // after 11 goes back to 9's right i.e. null therefore return 0
    // left of 9(11) gives 1 and right of 9(null) gives 0
    // therefore diameter till 9 = (0,1+0) = 1 and height of 9= (1,0)+1 = 2;
    // now, goes back to right of 3 (proceed post order wise(hint)) -> goes till last of left
    // (15) -> left=0,right=0 (both nulls) -> diameter = (2,0)=2 (not of 15 but ab tak ka highest store kr rakha h)
    // (0,0)+1=1 -> height(15)=1 -> goes to 7 -> same return 1 -> dia(till20) = (2,2)=2
    // height(20)= (1,1)+1=2 returns 2 -> Now 3 -> left=2, right=2 -> dia=(2,2+2)=4,height(3)=(2,2)+1=3
    // Stack empties -> final diameter = 4 ans
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