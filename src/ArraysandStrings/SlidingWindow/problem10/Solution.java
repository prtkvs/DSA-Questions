package ArraysandStrings.SlidingWindow.problem10;

class Solution {
    public int maxProfit(int[] prices) {
        int minSofar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            minSofar = Math.min(minSofar,prices[i]);
            maxProfit = Math.max(maxProfit,(prices[i]-minSofar));
        }
        return maxProfit;
    }
}
