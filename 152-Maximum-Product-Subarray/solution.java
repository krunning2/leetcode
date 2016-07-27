public class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max =1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = min;
                min = Math.min(nums[i], max * nums[i]);
                max = Math.max(nums[i], tmp * nums[i]);
            } else if(nums[i] > 0){
                max = Math.max(nums[i] * max, nums[i]);
                min = Math.min(nums[i], nums[i] * min);
            }else{
                max = 0;
                min = 0;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}