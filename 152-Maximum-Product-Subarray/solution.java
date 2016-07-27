public class Solution {
    public int maxProduct(int[] nums) {
        long min = Integer.MAX_VALUE;
        long max =Integer.MIN_VALUE;
        long res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                res = Math.max(res, nums[i] * min);
                int tmp = min;
                min = max * nums[i];
                max = tmp * nums[i];
            } else {
                res = Math.max(res, nums[i] * max);
                max = nums[i] * max;
                min = nums[i] * min;
            }
        }
        return res;
    }
}