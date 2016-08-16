public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] left = int[len];
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(max, prices[i] - lowest);
            left[i] = max;
            lowest = Math.min(lowest, prices[i]);
        }
        max = 0;
        int highest = 0;
        int res = 0;
        for(int i = len - 1; i >= 0; i --){
            max = highest - prices[i];
            res = Math.max(res, max + left[i]);
            highest = Math.max(highest, prices[i]);
        }
        return res;
    }
}