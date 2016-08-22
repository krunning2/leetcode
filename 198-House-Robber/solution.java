public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int[] dp = new int[3];
        dp[0] = nums[0];
        if(nums.length == 1){
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i % 3] = Math.max(nums[i] + dp[(i - 2) % 3], dp[(i - 1) % 3]); 
        }
        return dp[(nums.length - 1) % 3];
    }
}