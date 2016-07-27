public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[1], nums[0]);
        return Math.max(helper(nums, 1, nums.length - 1), helper(nums, 0, nums.length - 2));
    }
    private int helper(int[] nums, int s, int e){
        int[] dp = new int[e + 1];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s], nums[s + 1]);
        for(int i = 2; i <= e - s; i++){
            dp[i] = Math.max(dp[(i - 2)] + nums[i + s], dp[(i - 1)]);
        }
        return dp[e - s];
    }
}