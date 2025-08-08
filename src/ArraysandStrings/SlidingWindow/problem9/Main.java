package ArraysandStrings.SlidingWindow.problem9;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index= 0;
        while(index<k){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[index]) dq.pollLast();
            dq.offerLast(index);
            index++;
        }
        res[0] = nums[dq.peekFirst()];

        for(int i=1;i<n-k+1;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=(i-1)) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i+k-1]) dq.pollLast();
            dq.offerLast(i+k-1);
            res[i] = nums[dq.peekFirst()];
        }
        return res;
    }
}

public class Main {
    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = sol.maxSlidingWindow(nums,3);
        for(int num: ans){
            System.out.print(num+" ");
        }
    }
}
