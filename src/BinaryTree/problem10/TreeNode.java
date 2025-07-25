package BinaryTree.problem10;

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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        //reached till bottom
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        //swap and fill out of stack
        root.right = left;
        root.left = right;
        return root;
    }
}