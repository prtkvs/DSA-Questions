package BinaryTree.problem2;

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
    public List<Double> avgOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            double sum=0;

            for(int j=0;j<level.size();j++){
                sum += level.get(j);
            }
            double avg = sum/levelSize;
            result.add(avg);
        }
        return result;
    }
}

public class Main2 {
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

        // Call BFS
        Solution sol = new Solution();
        List<Double> avg = sol.avgOfLevels(root);

        // Print result
        for (double level : avg) {
            System.out.println(level);
        }
    }
}
