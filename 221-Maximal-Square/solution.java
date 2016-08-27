public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        if(matrix.length == 0 || matrix[0].length == 0) return matrix[0][0] - '0';
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp  = new int[2][n];
        int res = 0;
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j] - '0';
            res = Math.max(res, dp[0][j]);
        }
        for(int i = 1; i < m; i++){
            dp[i % 2][0] = matrix[i][0] - '0';
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    dp[i % 2][j] = Math.min(dp[i % 2][j - 1], Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j])) + 1;
                    res = Math.max(res, dp[i % 2][j]);
                }else{
                    dp[i % 2][j] = 0;
                }
            }
        }
        return res * res;
    }
}