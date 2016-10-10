public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j != 0){
                    dp[j] = grid[i][j] + dp[j - 1];
                }else if(i == 0 && j == 0){
                    dp[j] = grid[i][j];
                }else if(j == 0 && i != 0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}