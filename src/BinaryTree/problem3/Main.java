package BinaryTree.problem3;

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

// BFS solution
class Solution {
    public TreeNode findSuccessor(TreeNode root, int key){
        if(root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode ans = null ;
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                //after adding childrens
                if(curr.val==key){
                    ans = q.poll();
                    break;
                }
            }
        }
        return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        // Manually constructing the tree in the image:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Call
        Solution sol = new Solution();
        TreeNode ans = sol.findSuccessor(root,20);

        // Print result
        System.out.print(ans.val);
    }
}
