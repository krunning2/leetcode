public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        // // 第一列赋值
        // for(int i = 0; i < m; i++){
        //     dp[i % 2][0] = matrix[i][0] - '0';
        //     max = Math.max(max, dp[i % 2][0]);
        // }
        // 第一行赋值
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        // 递推
        for(int i = 1; i < m; i++){
            dp[i % 2][0] = matrix[i][0] - '0';
            for(int j = 1; j < n; j++){
                dp[i % 2][j] = matrix[i][j] == '1' ? Math.min(dp[(i-1) % 2][j-1], Math.min(dp[(i-1) % 2][j], dp[i % 2][j-1])) + 1 : 0;
                max = Math.max(max, dp[i % 2][j]);
            }
        }
        return max * max;
    }
}