public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int m = prices.length;
        int[] leftMax = new int[m];
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
            leftMax[i] = profit;
        }
        int max = 0;
        profit = 0;
        int res = 0;
        for(int i = prices.length - 1; i >= 0; i--){
            profit = Math.max(profit, max - prices[i]);
            max = Math.max(max, prices[i]);
            res = Math.max(res, profit + leftMax[i]);
        }
        return res;
    }
}