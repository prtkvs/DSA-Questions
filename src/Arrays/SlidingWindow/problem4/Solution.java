package Arrays.SlidingWindow.problem4;

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int i=0, j=0, sum=0, len =0;
        int minLen = Integer.MAX_VALUE;
        while(j<n){
            sum+=arr[j];
            if(sum>x){
                len = j-i+1;
                minLen = Math.min(minLen, len);
                //shrinking
                while(i<j && sum>x){
                    sum-=arr[i];
                    i++;
                    if(sum>x){
                        len = j-i+1;
                        minLen = Math.min(minLen, len);
                    }
                }
            }
            j++;
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        else return minLen;
    }
}
