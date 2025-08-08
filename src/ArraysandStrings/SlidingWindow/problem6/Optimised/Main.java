package ArraysandStrings.SlidingWindow.problem6.Optimised;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && i<=map.get(ch)){
                i = map.get(ch)+1;
            }
            map.put(ch,j);
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return (maxLen == Integer.MIN_VALUE)?0:maxLen;
    }
}

public class Main {
    public static void main (String[] args) {
        Solution sol = new Solution();
        int ans = sol.lengthOfLongestSubstring("abcabcbb");
        System.out.print(ans);
    }
}
