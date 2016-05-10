public class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] new_nums = new int[len + 2];
        for(int i = 1; i <= len; i++) new_nums[i] = nums[i - 1];
        new_nums[0] = new_nums[len + 1] = 1;
        for(int k = 0; k < len; k ++){
            for(int i = 1; i < n - k; i ++){
                int j = i + k;
                for(int x = i; x <= j; x ++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + new_nums[i - 1] * new_nums[x] * new_nums[j + 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][len];
    }
}