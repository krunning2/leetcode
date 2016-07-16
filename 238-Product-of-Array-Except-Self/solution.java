public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = nums[i - 1] * res[i - 1];
        }
        int tmp = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }
}