public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int n = nums.length;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for(int i = 0 ; i < nums.length; i++){
            if(Math.abs(nums[i]) <= n){
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}