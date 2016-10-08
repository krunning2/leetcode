public class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        int localMin = 1;
        int localMax = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                localMax = Math.max(nums[i], localMax * nums[i]);
                localMin = Math.min(nums[i], localMin * nums[i]);
            }else if(nums[i] == 0){
                localMax = 0;
                localMin = 0;
            }else{
                int tmp = localMax;
                localMax = Math.max(nums[i], localMin * nums[i]);
                localMin = Math.min(nums[i], tmp * nums[i]);
            }
            max = Math.max(max, localMax);
        }
        return max;
    }
}