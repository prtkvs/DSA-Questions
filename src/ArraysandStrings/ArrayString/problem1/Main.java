package ArraysandStrings.ArrayString.problem1;

import java.util.*;

class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            sb.append(chars[i]);
            int count =1;
            while ((i + 1)<chars.length && chars[i + 1] == chars[i]) {
                count++;
                i++;
            }
            if(count>1) sb.append(count);
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}

public class Main {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        Solution sol = new Solution();
        int ans = sol.compress(chars);
        System.out.print(ans);
    }
}

