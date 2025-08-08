package LinkedList.problem1;

// LC - 160. Intersection of Two Linked Lists
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=null){
            map.put(temp1,temp1.val);
            temp1= temp1.next;
        }
        // temp1 mat use karna ab wo null pahuch chuka hai
        while(temp2!=null){
            if(map.containsKey(temp2) && map.get(temp2)==temp2.val){
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        // Create common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // Create listA: 4 -> 1 -> [8 -> 4 -> 5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // Create listB: 5 -> 6 -> 1 -> [8 -> 4 -> 5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        Solution sol = new Solution();
        ListNode ans = sol.getIntersectionNode(headA, headB);

        if (ans != null)
            System.out.println("Intersected at '" + ans.val + "'");
        else
            System.out.println("No intersection");
    }
}