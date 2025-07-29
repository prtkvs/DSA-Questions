package BinaryTree.problem5;
// LC 116
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        // Think complete ques. as PERFECT BINARY TREE
        /*      1 -> null
              /   \
             2  -> 3 -> null
           /  \   /  \
          4 -> 5->6 -> 7 -> null
        */
        Node leftMost = root; //initialised as root
        while(leftMost.left!=null){ //till reached leaf
            Node curr = leftMost;
            while(curr!=null){ // since null bhi show krna hai
                curr.left.next = curr.right; // 4->5
                if(curr.next!=null){
                    curr.right.next = curr.next.left; // 5->6
                }
                curr = curr.next; // 2 -> 3 -> null
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}