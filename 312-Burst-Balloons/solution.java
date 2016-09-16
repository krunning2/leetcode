public class Solution {
    //dp[i][j] = max(dp[i][j], nums[i - 1] * nums[k] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]) where i < k < j
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] new_nums = new int[len + 2];
        for(int i = 1; i <= len; i++) new_nums[i] = nums[i - 1];
        new_nums[0] = new_nums[len + 1] = 1;
        for(int l = 0; l < len; l ++){
            for(int left = 1; left <= len - l; left ++){
                int right = left + l;
                for(int k = left; k <= right; k ++){
                    dp[left][right] = Math.max(dp[left][right], dp[left][k - 1] + new_nums[left - 1] * new_nums[k] * new_nums[right + 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][len];
    }
}