package BinaryTree.problem17;

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

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0) return null;
        int r = preorder[0];
        int idx = 0; //initialised
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==r){
                idx = i; //got the index
            }
        }
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,idx+1),Arrays.copyOfRange(inorder,0,idx));
        node.right = buildTree(Arrays.copyOfRange(preorder,idx+1,preorder.length),Arrays.copyOfRange(inorder,idx+1,inorder.length));
        return node;
    }

}
