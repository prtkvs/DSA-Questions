package Arrays.SlidingWindow.problem6.NotOptimised;
// LC - 3
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0;
        int maxLen = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(set.contains(ch)){
                while(i<j && set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(ch);
            maxLen = Math.max(maxLen , j-i+1);
            j++;
        }
        return (maxLen == Integer.MIN_VALUE)?0: maxLen;
    }
}
