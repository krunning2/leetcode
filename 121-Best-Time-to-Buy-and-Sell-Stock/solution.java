public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int price : prices){
            res = Math.max(price - min, res);
            min = Math.min(price, min);
        }
        return res;
    }
}