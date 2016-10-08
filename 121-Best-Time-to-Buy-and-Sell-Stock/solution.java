public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int price : prices){
            max = Math.max(max, price - min);
            min = Math.min(min, price);
        }
        return max;
    }
}