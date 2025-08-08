package ArraysandStrings.TwoPointer.problem3;
// Leetcode - 88
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,p=0;
        int[] ans = new int[m+n];
        while(i<m && j<n) {
            if(p<m+n) {
                if(nums1[i]<=nums2[j]) {
                    ans[p++]=nums1[i++];
                } else {
                    ans[p++] = nums2[j++];
                }
            }
        }
        if(i==m) {
            while(j!=n) {
                ans[p++] = nums2[j++];

            }
        }
        else if (j==n) {
            while(i!=m) {
                ans[p++] = nums1[i++];
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = ans[k];
        }
    }
}
