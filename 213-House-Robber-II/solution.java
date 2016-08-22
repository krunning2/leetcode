public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[1], nums[0]);
        return Math.max(helper(nums, 1, nums.length - 1), helper(nums, 0, nums.length - 2));
    }
    private int helper(int[] nums, int s, int e){
        int[] dp = new int[3];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s + 1], nums[s]);
        for(int i = 2; i <= e; i++){
            dp[i % 3] = Math.max(dp[(i - 2) % 3] + nums[s + i], dp[(i - 1) % 3]);
        }
        return dp[(e - s) % 3];
    }
}