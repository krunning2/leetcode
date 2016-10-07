public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;
        for(int n : nums){
            sum += n;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
}