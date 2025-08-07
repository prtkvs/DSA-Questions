package Arrays.SlidingWindow.problem3;
// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
import java.util.*;
class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int n = arr.size();
        int minDiff = Math.abs(arr.get(0)-arr.get(m-1));
        int diff;
        for(int i=1;i<n-m+1;i++){
            diff = Math.abs(arr.get(i) - arr.get(i+m-1));
            minDiff = Math.min(diff,minDiff);
        }
        return minDiff;
    }
}


public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(9);
        list.add(56);
        list.add(7);
        list.add(9);
        list.add(12);
        int m =5;
        Solution sol = new Solution();
        int ans = sol.findMinDiff(list, m);
        //print result
        System.out.print(ans);
    }
}
