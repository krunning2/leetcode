public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int j = 2; j <= n; j++){
            for(int i = j - 1; i >= 1; i --){
                if(j == i + 1){
                    dp[i][j] = i;
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = i + 1; k < j; k++){
                        min = Math.min(min, Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[1][n];
    }
}