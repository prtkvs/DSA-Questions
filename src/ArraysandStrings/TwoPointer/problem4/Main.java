package ArraysandStrings.TwoPointer.problem4;
// lc - trapping rain water
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }

        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        int sum =0;
        for(int i=0;i<n;i++){
            sum+= (Math.min(left[i],right[i])-height[i]);
        }
        return sum;
    }
}


public class Main
{
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution sol = new Solution();
        int ans = sol.trap(height);
        //print result
        System.out.println(ans);
    }
}
