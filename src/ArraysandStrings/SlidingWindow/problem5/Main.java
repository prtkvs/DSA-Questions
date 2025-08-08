package ArraysandStrings.SlidingWindow.problem5;
// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i=0,j=0,unique=0, len =0;
        int maxLen = Integer.MIN_VALUE;
        int freqHash[] = new int[26];
        while(j<s.length()){
            int index = s.charAt(j)-97;
            if(freqHash[index]==0){
                unique++;
            }
            freqHash[index]++;

            if(unique == k){
                len = j-i+1;
                maxLen = Math.max(maxLen,len);
            }

            if(unique>k){
                while(i<j && unique>k){
                    int idx = s.charAt(i)-97;
                    freqHash[idx]--;
                    if(freqHash[idx]==0) unique--;
                    i++;
                }
            }
            j++;
        }
        return (maxLen == Integer.MIN_VALUE)?-1: maxLen;
    }
}

public class Main{
    public static void main (String[] args) {
        Solution sol = new Solution();
        int ans = sol.longestKSubstr("aabacbebebe",3);
        System.out.print(ans);
    }
}
