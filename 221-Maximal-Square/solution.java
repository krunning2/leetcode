public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[2][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            dp[i % 2][0] = matrix[i][0];
            max = Math.max(max, dp[0][i]);
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
            max = Math.max(max, dp[0][i]);
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    dp[i % 2][j] = 0;
                }else{
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[i % 2][j], dp[(i - 1) % 2][j])) + 1;
                }
                max = Math.max(max, dp[i % 2][j]);
            }
        }
        return max * max;
    }
}