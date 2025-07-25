package BinaryTree.problem1;
import java.util.*;
public class BFS {
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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int levelSize = q.size();
                //You store the queue’s size before entering the loop, using it as the count for how many nodes exist in the current level.
                List<Integer> level = new ArrayList<>(levelSize);
                for(int i=0; i<levelSize; i++){
                    TreeNode curr = q.poll();
                    level.add(curr.val);
                    if(curr.left!=null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right);
                }
                result.add(level);
            }
            return result;
        }
    }
}
