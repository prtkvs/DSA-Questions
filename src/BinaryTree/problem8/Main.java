package BinaryTree.problem8;
import java.util.*;
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    level.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                } else {
                    level.add(null); // Important for symmetry check
                }
            }

            if (!isPalindrome(level)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPalindrome(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            Integer l = list.get(left);
            Integer r = list.get(right);

            if (l == null && r == null) {
            // if both nodes at end are null then also they are symmetric
            // therefore don't mark it false
            // helping in ignoring this scenario, otherwise next condition will make it false
            } else if (l == null || r == null || !l.equals(r)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}