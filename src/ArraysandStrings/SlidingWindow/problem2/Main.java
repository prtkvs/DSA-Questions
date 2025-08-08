package ArraysandStrings.SlidingWindow.problem2;
import java.util.*;
class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        int p=0;
        while(p<k){
            if(arr[p]<0) q.offer(arr[p]);
            p++;
        }
        List<Integer> result = new ArrayList<>();
        // pre computation of initial window
        if(q.isEmpty()){
            result.add(0);
        }else{
            result.add(q.peek());
        }

        //window  started
        for(int i=1;i<n-k+1;i++){
            int next = arr[i+k-1];
            int prev = arr[i-1];
            if(prev<0) q.poll();
            if(next<0) q.add(next);
            if(q.isEmpty()){
                result.add(i,0);
            }else{
                result.add(i,q.peek());
            }
        }
        return result;
    }
}


public class Main
{
    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        int k =3;
        Solution sol = new Solution();
        List<Integer> ans = sol.firstNegInt(arr, k);
        //print result
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
