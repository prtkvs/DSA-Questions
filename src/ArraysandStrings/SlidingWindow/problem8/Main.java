package ArraysandStrings.SlidingWindow.problem8;
// LC - 76
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int unique = map.size();
        int i=0,j=0,len =0,minLen = Integer.MAX_VALUE, si=-1;
        int n = s.length();
        while(j<n){
            //expansion
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) unique--;
            }
            // ans zone
            while(unique==0){
                len = j-i+1;
                if(len<minLen){
                    minLen = len;
                    si = i;
                }
                // shrinking
                ch = s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                    if(map.get(ch)>0) unique++;
                }
                i++;
            }
            j++;
        }
        if(si==-1) return "";
        return s.substring(si,si+minLen);
    }
}

public class Main {
    public static void main (String[] args) {
        Solution sol = new Solution();
        String ans = sol.minWindow("ADOBECODEBANC","ABC"); //[0,6]
        System.out.print(ans);
    }
}
