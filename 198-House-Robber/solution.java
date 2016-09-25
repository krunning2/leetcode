public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i % 2] = Math.max(nums[i] + dp[(i - 2) % 2], dp[(i - 1) % 2]);
        }
        return dp[(nums.length - 1) % 2];
    }
}