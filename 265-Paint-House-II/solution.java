public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] minCosts = new int[2][k];
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < k; i++){
            minCosts[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < costs.length; i++){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                int cur = minCosts[(i - 1) % 2][j];
                if(min1 > cur){
                    min2 = min1;
                    min1 = cur;
                }else if(min2 > cur){
                    min2 = cur;
                }
            }
            for(int j = 0; j < k; j++){
                minCosts[i % 2][j] = min1 == minCosts[(i - 1) % 2][j] ? min2 + costs[i][j] : min1 + costs[i][j];
            }
        }
        for(int i = 0; i < k; i++){
            res = Math.min(res, minCosts[(n - 1) % 2][i]);
        }
        return res;
    }
}