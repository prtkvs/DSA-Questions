package BinaryTree.problem13.NotOptimised;
import java.util.*;

// TreeNode as defined
public class TreeNode {
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

class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        preOrder(root,q);
        TreeNode curr = q.poll();
        while(!q.isEmpty()){
            TreeNode next= q.poll();
            curr.right = next;
            curr.left = null;
            curr = next;
        }

    }

    public void preOrder(TreeNode node, Queue<TreeNode> q){
        if(node==null) return;
        q.add(node);
        preOrder(node.left,q);
        preOrder(node.right,q);
    }
}
