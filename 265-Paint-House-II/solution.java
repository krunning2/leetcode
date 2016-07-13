public class Solution {
    public int minCostII(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < m; i ++){
            int min2 = Integer.MAX_VALUE;
            int min1 = Integer.MAX_VALUE;
            for(int j = 0; j < n; j ++){
                int cur = dp[i - 1][j];
                if(cur < min1){
                    min2 = min1;
                    min1 = cur;
                }else if(cur < min2){
                    min2 = cur;
                }
            }
            for(int j = 0; j < n; j ++){
                dp[i][j] = dp[i][j - 1] == min1 ? min2 + costs[i][j] : min1 + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}

