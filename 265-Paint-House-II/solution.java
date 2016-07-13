public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[2][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < m; i ++){
            int min2 = Integer.MAX_VALUE;
            int min1 = Integer.MAX_VALUE;
            for(int j = 0; j < n; j ++){
                int cur = dp[(i - 1) % 2][j];
                if(cur < min1){
                    min2 = min1;
                    min1 = cur;
                }else if(cur < min2){
                    min2 = cur;
                }
            }
            for(int j = 0; j < n; j ++){
                dp[i % 2][j] = dp[(i-1) % 2][j] == min1 ? min2 + costs[i][j] : min1 + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, dp[(m - 1) % 2][i]);
        }
        return res;
    }
}

