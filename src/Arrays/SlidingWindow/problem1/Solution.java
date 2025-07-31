package Arrays.SlidingWindow.problem1;
// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int sum =0;
        int maxSum =0;
        //compute first sum
        for(int i=0;i<k;i++){
            sum+= arr[i];
        }
        maxSum = sum;
        for(int i=1;i<n-k+1;i++){
            int prev = arr[i-1];
            int next = arr[i+k-1];
            sum = sum - prev + next;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
