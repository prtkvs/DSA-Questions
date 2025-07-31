package Arrays.TwoPointer.problem2;
// TWO SUM (LC 1)
import java.util.*;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = Arrays.copyOf(nums, nums.length); // copy original
        Arrays.sort(ans); // sort for two-pointer

        int s = 0;
        int e = ans.length - 1;

        int num1 = -1, num2 = -1;

        while (s < e) {
            int sum = ans[s] + ans[e];
            if (sum == target) {
                num1 = ans[s];
                num2 = ans[e];
                break;
            } else if (sum < target) {
                s++;
            } else {
                e--;
            }
        }

        // Find original indices of num1 and num2 in nums
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1 && idx1 == -1) {
                idx1 = i;
            } else if (nums[i] == num2 && idx2 == -1) {
                idx2 = i;
            }
        }

        return new int[]{idx1, idx2};
    }
}