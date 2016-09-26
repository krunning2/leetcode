public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int k = costs[0].length;
        int[][] minCost = new int[2][k];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            minCost[0][i] = costs[0][i];
        }
        for(int i = 1; i < costs.length; i++){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                int cur = minCost[(i - 1) % 2][j];
                if(min1 > cur){
                    min2 = min1;
                    min1 = cur;
                }else if(min2 > cur){
                    min2 = cur;
                }
            }
            for(int j = 0; j < k; j++){
                minCost[i % 2][j] = min1 == minCost[(i - 1) % 2][j] ? costs[i][j] + min2 : costs[i][j] + min1;
            }
        }
        for(int j = 0; j < k; j++){
            res = Math.min(res, minCost[(costs.length - 1) % 2][j]);
        }
        return res;
    }
}