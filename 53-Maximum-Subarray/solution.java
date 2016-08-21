public class Solution {
    public int maxSubArray(int[] nums) {
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(sum - min, max);
            min = Math.min(sum, min);
        }
        return max;
    }
}