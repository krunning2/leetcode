public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[2][n];
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }else{
                break;
            }
        }
        
        for(int i = 1; i < m; i++){
            dp[i % 2][0] = dp[(i - 1) % 2][0] != 0 && obstacleGrid[i][0] != 1 ? 1 : 0;
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
                }else{
                    dp[i % 2][j] = 0;
                }
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}