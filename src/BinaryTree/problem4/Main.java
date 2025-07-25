package BinaryTree.problem4;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            int levelSize = dq.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize; i++){
                if(!reverse){
                    TreeNode curr = dq.pollFirst();
                    level.add(curr.val);
                    if(curr.left!=null) dq.addLast(curr.left);
                    if(curr.right!=null) dq.addLast(curr.right);
                } else{
                    TreeNode curr = dq.pollLast();
                    level.add(curr.val);
                    if(curr.right!=null) dq.addFirst(curr.right);
                    if(curr.left!=null) dq.addFirst(curr.left);
                }
            }
            reverse = !reverse; //here since queue is changing not loop mein level
            result.add(level);
        }
        return result;
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
        List<List<Integer>> ans = sol.zigzagLevelOrder(root);

        // Print result
        for(List<Integer> list : ans){
            System.out.print(list);
        }
    }
}
