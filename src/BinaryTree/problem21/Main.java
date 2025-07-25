package BinaryTree.problem21;

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

// Path Find
class Solution {
    public boolean findPath(TreeNode root, int[] arr) {
        if(root==null){
            return arr.length == 0;
        }
        return helper(root,arr,0); //idx from 0 since it's root
    }

    public boolean helper(TreeNode node, int[] arr, int idx ){
        if(node==null) return false;
        // not existence case :
        if(idx>=arr.length || node.val!=arr[idx]) return false;
        //existence case
        if(node.left==null && node.right==null && idx==arr.length-1) return true;

        return helper(node.left,arr,idx+1) || helper(node.right,arr,idx+1);
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
        int[] arr = {6,10,81};
        // [return type] [variable] = sol.[function name(pass arg)];
        boolean ans = sol.findPath(root,arr);

        // Print result
        System.out.println(ans);
    }
}