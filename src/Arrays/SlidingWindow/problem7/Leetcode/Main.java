package Arrays.SlidingWindow.problem7.Leetcode;
// LC - 438
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int k = p.length();
        int n = s.length();
        if(n<k) return list;
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        //initialised window
        for(int i=0;i<k;i++){
            int index = p.charAt(i)-97;
            int idx = s.charAt(i)-97;
            pFreq[index]++;
            sFreq[idx]++;
        }
        if(Arrays.equals(pFreq,sFreq)){
            list.add(0);
        }
        for(int i=1;i<n-k+1;i++){
            int prev = s.charAt(i-1)-97;
            int next = s.charAt(i+k-1)-97;
            sFreq[prev]--;
            sFreq[next]++;
            if(Arrays.equals(pFreq,sFreq)){
                list.add(i);
            }
        }
        return list;
    }
}

public class Main {
    public static void main (String[] args) {
        Solution sol = new Solution();
        List<Integer> ans = sol.findAnagrams("cbaebabacd","abc"); //[0,6]
        for(int num: ans){
            System.out.print(num+" ");
        }
    }
}
