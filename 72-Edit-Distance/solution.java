public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[2][n + 1];
        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            dp[i % 2][0] = i;
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                }else{
                    dp[i % 2][j] = Math.min(Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j]), dp[(i - 1) % 2][j - 1]) + 1;
                }
            }
        }
        return dp[m % 2][n];
    }
}