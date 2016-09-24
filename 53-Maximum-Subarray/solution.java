public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int min = 0;
        int res = Integer.MIN_VALUE;
        for(int n : nums){
            sum += n;
            res = Math.max(res, sum - min);
            min = Math.min(min, sum);
        }
        return res;
    }
}